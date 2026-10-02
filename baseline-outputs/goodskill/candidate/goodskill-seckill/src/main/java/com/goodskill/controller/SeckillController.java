package com.goodskill.controller;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.goodskill.dto.ExposerDTO;
import com.goodskill.service.GoodsEsService;
import com.goodskill.service.GoodsService;
import com.goodskill.service.SeckillService;
import com.goodskill.vo.SeckillVO;
import com.goodskill.dto.Result;
import com.goodskill.dto.ResponseDTO;
import com.goodskill.util.UploadFileUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import com.goodskill.DTO.Result;
@Tag(name = "秒杀管理")
@Controller
@RequestMapping("/seckill")
@Validated
@Slf4j
public class SeckillController {

 private  Logger logger;

@Resource
 private  SeckillService seckillService;

@Resource
 private  GoodsService goodsService;

@Resource
 private  GoodsEsService goodsEsService;

@Resource
 private  UploadFileUtil uploadFileUtil;


@SneakyThrows
@Transactional
@RequestMapping(value = "/upload/{seckillId}/create", method = RequestMethod.POST)
public String uploadPhoto(MultipartFile file,Long seckillId){
    SeckillVO seckill = seckillService.findById(seckillId);
    String url = uploadFileUtil.uploadFile(file);
    goodsService.uploadGoodsPhoto(seckill.getGoodsId(), url);
    return url;
}


@Transactional
@GetMapping(value = "/{seckillId}/edit")
public String edit(Model model,Long seckillId){
    model.addAttribute("seckillInfo", seckillService.getInfoById(seckillId));
    return "seckill/edit";
}


@PostMapping(value = "/create")
public String addSeckill(SeckillVO seckill){
    seckillService.save(seckill);
    return null;
}


@PostMapping(value = "/{seckillId}/exposer", produces = { "application/json;charset=UTF-8" })
@ResponseBody
public Result<ExposerDTO> exposer(Long seckillId){
    Result<ExposerDTO> result;
    try {
        ExposerDTO exposerDTO = seckillService.exportSeckillUrl(seckillId);
        result = Result.ok(exposerDTO);
    } catch (Exception e) {
        logger.error(e.getMessage(), e);
        result = Result.fail(e.getMessage());
    }
    return result;
}


@Transactional
@PostMapping(value = "/{seckillId}/update")
public String update(SeckillVO seckill){
    seckillService.saveOrUpdateSeckill(seckill);
    return null;
}


@RequestMapping(value = "/pay/Qrcode/{QRfilePath}", method = RequestMethod.GET)
public String payTransaction(String QRfilePath,Model model) throws IOException{
    model.addAttribute("QRfilePath", QRfilePath);
    return "seckill/payByQrcode";
}


@GetMapping(value = "/goods/search/{goodsName}", produces = { "application/json;charset=UTF-8" })
@ResponseBody
public ResponseDTO searchGoods(String goodsName){
    List goodsList = goodsEsService.searchWithNameByPage(goodsName);
    ResponseDTO responseDto = ResponseDTO.ok();
    responseDto.setData(goodsList.toArray());
    return responseDto;
}


@GetMapping(value = "/{seckillId}/detail")
public String detail(Long seckillId,Model model){
    if (seckillId == null) {
        return "redirect:/seckill/list";
    }
    SeckillVO seckillInfo;
    seckillInfo = seckillService.findById(seckillId);
    if (seckillInfo == null) {
        return "forward:/seckill/list";
    }
    model.addAttribute("seckillInfo", seckillInfo);
    return "detail";
}


@Operation(summary = "秒杀列表", description = "分页显示秒杀列表")
@Parameters({ @Parameter(name = "offset", description = "当前页数", required = true), @Parameter(name = "limit", description = "每页显示的记录数", required = true) })
@GetMapping(value = "/list")
public String list(Model model,int offset,int limit,String goodsName){
    Page<SeckillVO> pageInfo = seckillService.getSeckillList(offset, limit, goodsName);
    long totalNum = pageInfo.getTotal();
    model.addAttribute("list", pageInfo.getRecords());
    model.addAttribute("totalNum", totalNum);
    model.addAttribute("pageNum", pageInfo.getPages());
    model.addAttribute("limit", limit);
    return "list";
}


@GetMapping(value = "/new")
public String toAddSeckillPage(){
    return "seckill/addSeckill";
}


@GetMapping(value = "/{seckillId}/delete")
public String delete(Long seckillId){
    seckillService.removeBySeckillId(seckillId);
    return null;
}


}