DROP TABLE THRESHOLD_CONFIG;

CREATE TABLE THRESHOLD_CONFIG
(
  PARAM_NAME        VARCHAR2(100 BYTE),
  PARAM_WARNING     NUMBER(10, 2),
  PARAM_CRITICAL		NUMBER(10, 2)
);