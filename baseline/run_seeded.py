"""Run app/main.py unchanged, with Python's random module seeded.

database.py appends random characters to the foreign-key columns it creates; seeding
makes repeated runs produce identical candidates. Usage: run_seeded.py <main.py args>
"""
import os
import random
import runpy
import sys

APP_DIR = os.path.join(os.path.dirname(os.path.abspath(__file__)), '..', 'app')

random.seed(int(os.environ.get('MR_SEED', '0')))
os.chdir(APP_DIR)
sys.path.insert(0, APP_DIR)
sys.argv = ['main.py'] + sys.argv[1:]
runpy.run_path('main.py', run_name='__main__')
