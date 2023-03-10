--------------------------------------------------------
--  DDL for Table MEMBER_RANK
--------------------------------------------------------

  CREATE TABLE "SCOTT"."MEMBER_RANK" 
   (	"NICKNAME" VARCHAR2(20 BYTE), 
	"SCORE" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Ref Constraints for Table MEMBER_RANK
--------------------------------------------------------

  ALTER TABLE "SCOTT"."MEMBER_RANK" ADD CONSTRAINT "FK_NICKNAME" FOREIGN KEY ("NICKNAME")
	  REFERENCES "SCOTT"."SMEMBER" ("NICKNAME") ON DELETE CASCADE ENABLE;