/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2021/4/3 14:39:14                            */
/*==============================================================*/


ALTER TABLE SYS_ACCOUNT
   DROP CONSTRAINT FK_SYS_ACCO_REFERENCE_SYS_ORGA;

ALTER TABLE SYS_ACCOUNT_ROLE
   DROP CONSTRAINT FK_SYS_ACCO_REFERENCE_SYS_ACCO;

ALTER TABLE SYS_ACCOUNT_ROLE
   DROP CONSTRAINT FK_SYS_ACCO_REFERENCE_SYS_ROLE;

ALTER TABLE SYS_ROLE_MENU
   DROP CONSTRAINT FK_SYS_ROLE_REFERENCE_SYS_ROLE;

ALTER TABLE SYS_ROLE_MENU
   DROP CONSTRAINT FK_SYS_ROLE_REFERENCE_SYS_MENU;

DROP INDEX INDEX_LOGIN_ACCOUNT;

DROP TABLE SYS_ACCOUNT CASCADE CONSTRAINTS;

DROP TABLE SYS_ACCOUNT_ROLE CASCADE CONSTRAINTS;

DROP INDEX INDEX_SYS_ORGANIZATION;

DROP INDEX INDEX_SYS_ORGANIZTION_CODE;

DROP TABLE SYS_ORGANIZATION CASCADE CONSTRAINTS;

DROP INDEX IDNEX_SYS_ROLE_CODE;

DROP TABLE SYS_ROLE CASCADE CONSTRAINTS;

DROP TABLE SYS_ROLE_MENU CASCADE CONSTRAINTS;

DROP INDEX INDEX_SYS_MENU_ORDER;

DROP TABLE SYS_MENU CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: SYS_ACCOUNT                                           */
/*==============================================================*/
CREATE TABLE SYS_ACCOUNT 
(
   ID                   VARCHAR2(255)        NOT NULL,
   ORG_ID               VARCHAR2(255)        NOT NULL,
   LOGIN_ACCOUNT        VARCHAR2(255)        NOT NULL,
   NAME                 VARCHAR2(255)        NOT NULL,
   AVATAR               VARCHAR2(255),
   EMAIL                VARCHAR2(4000),
   PASSWORD             VARCHAR2(4000)       NOT NULL,
   PHONE                VARCHAR2(255),
   STATUS               NUMBER(1)            DEFAULT 0 NOT NULL,
   CREATE_DATE          VARCHAR2(255)        DEFAULT SYSDATE,
   CREATE_ACCOUNT_ID    VARCHAR2(255),
   CREATE_ACCOUNT_NAME  VARCHAR2(255),
   CONSTRAINT PK_SYS_ACCOUNT_ID PRIMARY KEY (ID)
);

COMMENT ON TABLE SYS_ACCOUNT IS
'ϵͳ�˺���Ϣ';

COMMENT ON COLUMN SYS_ACCOUNT.ORG_ID IS
'�˺�������֯����Id';

COMMENT ON COLUMN SYS_ACCOUNT.LOGIN_ACCOUNT IS
'��¼�˺�';

COMMENT ON COLUMN SYS_ACCOUNT.NAME IS
'�˺�����';

COMMENT ON COLUMN SYS_ACCOUNT.AVATAR IS
'�˺�ͷ��';

COMMENT ON COLUMN SYS_ACCOUNT.EMAIL IS
'�˺�����';

COMMENT ON COLUMN SYS_ACCOUNT.PASSWORD IS
'�˺�����';

COMMENT ON COLUMN SYS_ACCOUNT.PHONE IS
'�˺��ֻ�����';

COMMENT ON COLUMN SYS_ACCOUNT.STATUS IS
'�˺�״̬ 0 ͣ�� 1 ����';

COMMENT ON COLUMN SYS_ACCOUNT.CREATE_DATE IS
'�˺Ŵ���ʱ��';

COMMENT ON COLUMN SYS_ACCOUNT.CREATE_ACCOUNT_ID IS
'�˺Ŵ�����Id';

COMMENT ON COLUMN SYS_ACCOUNT.CREATE_ACCOUNT_NAME IS
'�˺Ŵ���������';

/*==============================================================*/
/* Index: INDEX_LOGIN_ACCOUNT                                   */
/*==============================================================*/
CREATE INDEX INDEX_LOGIN_ACCOUNT ON SYS_ACCOUNT (
   LOGIN_ACCOUNT ASC,
   EMAIL ASC,
   PHONE ASC
);

/*==============================================================*/
/* Table: SYS_ACCOUNT_ROLE                                      */
/*==============================================================*/
CREATE TABLE SYS_ACCOUNT_ROLE 
(
   ID                   VARCHAR2(255)        NOT NULL,
   ACCOUNT_ID           VARCHAR2(255),
   ROLE_ID              VARCHAR2(255),
   CONSTRAINT PK_SYS_ACCOUNT_ROLE_ID PRIMARY KEY (ID)
);

COMMENT ON TABLE SYS_ACCOUNT_ROLE IS
'�˺Ž�ɫ��Ϣ';

COMMENT ON COLUMN SYS_ACCOUNT_ROLE.ACCOUNT_ID IS
'�˺�Id';

COMMENT ON COLUMN SYS_ACCOUNT_ROLE.ROLE_ID IS
'��ɫId';

/*==============================================================*/
/* Table: SYS_ORGANIZATION                                      */
/*==============================================================*/
CREATE TABLE SYS_ORGANIZATION 
(
   ID                   VARCHAR2(255)        NOT NULL,
   CODE                 VARCHAR2(255)        NOT NULL,
   ORG_CODE             VARCHAR2(255)        NOT NULL,
   NAME                 VARCHAR2(255)        NOT NULL,
   PARENT_ID            VARCHAR2(255),
   AREA                 VARCHAR2(4000),
   CONTACT_PERSON       VARCHAR2(255),
   CONTACT_PHONE        VARCHAR2(255),
   CONTACT_EMAIL        VARCHAR2(255),
   CONSTRAINT PK_SYS_ORGANIZATION_ID PRIMARY KEY (ID)
);

COMMENT ON TABLE SYS_ORGANIZATION IS
'��֯�ṹ��Ϣ';

COMMENT ON COLUMN SYS_ORGANIZATION.CODE IS
'���� ���ڽ��п��ٲ鵽�¼����� �����ϼ�ʱ,ͬ���������й������¼�����������ϼ���Ϣ
�������4+4+4+4';

COMMENT ON COLUMN SYS_ORGANIZATION.ORG_CODE IS
'�������� �û�����ʱ�Զ���';

COMMENT ON COLUMN SYS_ORGANIZATION.NAME IS
'��������';

COMMENT ON COLUMN SYS_ORGANIZATION.PARENT_ID IS
'�ϼ�����Id';

COMMENT ON COLUMN SYS_ORGANIZATION.AREA IS
'����/��ַ';

COMMENT ON COLUMN SYS_ORGANIZATION.CONTACT_PERSON IS
'������ϵ��';

COMMENT ON COLUMN SYS_ORGANIZATION.CONTACT_PHONE IS
'������ϵ�绰';

COMMENT ON COLUMN SYS_ORGANIZATION.CONTACT_EMAIL IS
'������ϵ����';

/*==============================================================*/
/* Index: INDEX_SYS_ORGANIZTION_CODE                            */
/*==============================================================*/
CREATE INDEX INDEX_SYS_ORGANIZTION_CODE ON SYS_ORGANIZATION (
   CODE ASC
);

/*==============================================================*/
/* Index: INDEX_SYS_ORGANIZATION                                */
/*==============================================================*/
CREATE INDEX INDEX_SYS_ORGANIZATION ON SYS_ORGANIZATION (
   ORG_CODE ASC,
   NAME ASC
);

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
CREATE TABLE SYS_ROLE 
(
   ID                   VARCHAR2(255)        NOT NULL,
   CODE                 VARCHAR2(255)        NOT NULL,
   NAME                 VARCHAR2(255)        NOT NULL,
   PARENT_ID            VARCHAR2(255),
   STATUS               NUMBER(1)            DEFAULT 0 NOT NULL,
   DESCRIPTION          VARCHAR2(4000),
   CREATE_DATE          DATE                 DEFAULT SYSDATE,
   CREATE_ACCOUNT_ID    VARCHAR2(255),
   CONSTRAINT PK_SYS_ROLE_ID PRIMARY KEY (ID)
);

COMMENT ON TABLE SYS_ROLE IS
'ϵͳ��ɫ��Ϣ';

COMMENT ON COLUMN SYS_ROLE.ID IS
'��ɫ����';

COMMENT ON COLUMN SYS_ROLE.CODE IS
'��ɫ���� ���ڽ��п��ٲ鵽�¼���ɫ �����ϼ�ʱ,ͬ���������й������¼���ɫ������ϼ���Ϣ
�������4+4+4+4';

COMMENT ON COLUMN SYS_ROLE.NAME IS
'��ɫ����';

COMMENT ON COLUMN SYS_ROLE.PARENT_ID IS
'�ϼ���ɫID';

COMMENT ON COLUMN SYS_ROLE.STATUS IS
'��ɫ״̬ 0 ͣ�� 1 ����';

COMMENT ON COLUMN SYS_ROLE.DESCRIPTION IS
'��ɫ����';

COMMENT ON COLUMN SYS_ROLE.CREATE_DATE IS
'����ʱ��';

COMMENT ON COLUMN SYS_ROLE.CREATE_ACCOUNT_ID IS
'���������˺�';

/*==============================================================*/
/* Index: IDNEX_SYS_ROLE_CODE                                   */
/*==============================================================*/
CREATE INDEX IDNEX_SYS_ROLE_CODE ON SYS_ROLE (
   CODE ASC
);

/*==============================================================*/
/* Table: SYS_ROLE_MENU                                         */
/*==============================================================*/
CREATE TABLE SYS_ROLE_MENU 
(
   ID                   VARCHAR2(255)        NOT NULL,
   ROLE_ID              VARCHAR2(255),
   MENU_ID              VARCHAR2(255),
   CONSTRAINT PK_SYS_ROLE_MENU_ID PRIMARY KEY (ID)
);

COMMENT ON TABLE SYS_ROLE_MENU IS
'��ɫ�˵���Ϣ';

COMMENT ON COLUMN SYS_ROLE_MENU.ROLE_ID IS
'��ɫId';

COMMENT ON COLUMN SYS_ROLE_MENU.MENU_ID IS
'�˵�ID';

/*==============================================================*/
/* Table: SYS_MENU                                              */
/*==============================================================*/
CREATE TABLE SYS_MENU 
(
   ID                   VARCHAR2(255)        NOT NULL,
   PATH                 VARCHAR2(255)        NOT NULL,
   NAME                 VARCHAR2(255)        NOT NULL,
   ICON                 VARCHAR2(255),
   STATUS               NUMBER(1)            DEFAULT 0 NOT NULL,
   PARENT_ID            VARCHAR2(255),
   TYPE                 NUMBER(1)            NOT NULL,
   ORDER_INDEX          NUMBER(4)            DEFAULT 0,
   BREAD_CRUMB          VARCHAR2(255),
   AUTHORITY            VARCHAR2(400),
   CONSTRAINT PK_SYS_MENU_ID PRIMARY KEY (ID)
);

COMMENT ON TABLE SYS_MENU IS
'ϵͳ�˵���Ϣ';

COMMENT ON COLUMN SYS_MENU.PATH IS
'�˵�Url';

COMMENT ON COLUMN SYS_MENU.NAME IS
'�˵�����';

COMMENT ON COLUMN SYS_MENU.ICON IS
'�˵�ͼ��';

COMMENT ON COLUMN SYS_MENU.STATUS IS
'�˵�״̬ 0 ͣ�� 1 ����';

COMMENT ON COLUMN SYS_MENU.PARENT_ID IS
'�ϼ��˵�Id';

COMMENT ON COLUMN SYS_MENU.TYPE IS
'�˵�����   0 Ŀ¼ 1 �˵� 2 ��ť';

COMMENT ON COLUMN SYS_MENU.ORDER_INDEX IS
'�˵���������';

COMMENT ON COLUMN SYS_MENU.BREAD_CRUMB IS
'�˵����м';

COMMENT ON COLUMN SYS_MENU.AUTHORITY IS
'ShiroȨ�ޱ�ʶ';

/*==============================================================*/
/* Index: INDEX_SYS_MENU_ORDER                                  */
/*==============================================================*/
CREATE INDEX INDEX_SYS_MENU_ORDER ON SYS_MENU (
   ORDER_INDEX ASC
);

ALTER TABLE SYS_ACCOUNT
   ADD CONSTRAINT FK_SYS_ACCO_REFERENCE_SYS_ORGA FOREIGN KEY (ORG_ID)
      REFERENCES SYS_ORGANIZATION (ID);

ALTER TABLE SYS_ACCOUNT_ROLE
   ADD CONSTRAINT FK_SYS_ACCO_REFERENCE_SYS_ACCO FOREIGN KEY (ACCOUNT_ID)
      REFERENCES SYS_ACCOUNT (ID);

ALTER TABLE SYS_ACCOUNT_ROLE
   ADD CONSTRAINT FK_SYS_ACCO_REFERENCE_SYS_ROLE FOREIGN KEY (ROLE_ID)
      REFERENCES SYS_ROLE (ID);

ALTER TABLE SYS_ROLE_MENU
   ADD CONSTRAINT FK_SYS_ROLE_REFERENCE_SYS_ROLE FOREIGN KEY (ROLE_ID)
      REFERENCES SYS_ROLE (ID);

ALTER TABLE SYS_ROLE_MENU
   ADD CONSTRAINT FK_SYS_ROLE_REFERENCE_SYS_MENU FOREIGN KEY (MENU_ID)
      REFERENCES SYS_MENU (ID);

