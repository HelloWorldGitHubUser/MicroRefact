package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.model.media.Media;
import com.hoangtien2k3.ecommerce.dto.MediaDto;
import com.hoangtien2k3.ecommerce.dto.MediaPostVm;
import com.hoangtien2k3.ecommerce.dto.MediaVm;
import java.util.List;
public interface MediaService {


public Media saveMedia(MediaPostVm mediaPostVm)
;

public MediaVm getMediaById(Long id)
;

public List<MediaVm> getMediaByIds(List<Long> ids)
;

public void removeMedia(Long id)
;

public MediaDto getFile(Long id,String fileName)
;

}