@echo off
mysqlsh --sql root@localhost --password=786313 --file="%~dp0tmp_check.sql"
