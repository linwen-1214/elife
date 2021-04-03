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
'系统账号信息';

COMMENT ON COLUMN SYS_ACCOUNT.ORG_ID IS
'账号所属组织机构Id';

COMMENT ON COLUMN SYS_ACCOUNT.LOGIN_ACCOUNT IS
'登录账号';

COMMENT ON COLUMN SYS_ACCOUNT.NAME IS
'账号名称';

COMMENT ON COLUMN SYS_ACCOUNT.AVATAR IS
'账号头像';

COMMENT ON COLUMN SYS_ACCOUNT.EMAIL IS
'账号邮箱';

COMMENT ON COLUMN SYS_ACCOUNT.PASSWORD IS
'账号密码';

COMMENT ON COLUMN SYS_ACCOUNT.PHONE IS
'账号手机号码';

COMMENT ON COLUMN SYS_ACCOUNT.STATUS IS
'账号状态 0 停用 1 启用';

COMMENT ON COLUMN SYS_ACCOUNT.CREATE_DATE IS
'账号创建时间';

COMMENT ON COLUMN SYS_ACCOUNT.CREATE_ACCOUNT_ID IS
'账号创建人Id';

COMMENT ON COLUMN SYS_ACCOUNT.CREATE_ACCOUNT_NAME IS
'账号创建人名称';

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
'账号角色信息';

COMMENT ON COLUMN SYS_ACCOUNT_ROLE.ACCOUNT_ID IS
'账号Id';

COMMENT ON COLUMN SYS_ACCOUNT_ROLE.ROLE_ID IS
'角色Id';

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
'组织结构信息';

COMMENT ON COLUMN SYS_ORGANIZATION.CODE IS
'编码 用于进行快速查到下级机构 更改上级时,同步更新所有关联的下级机构编码的上级信息
编码规则4+4+4+4';

COMMENT ON COLUMN SYS_ORGANIZATION.ORG_CODE IS
'机构编码 用户创建时自定义';

COMMENT ON COLUMN SYS_ORGANIZATION.NAME IS
'机构名称';

COMMENT ON COLUMN SYS_ORGANIZATION.PARENT_ID IS
'上级机构Id';

COMMENT ON COLUMN SYS_ORGANIZATION.AREA IS
'地区/地址';

COMMENT ON COLUMN SYS_ORGANIZATION.CONTACT_PERSON IS
'机构联系人';

COMMENT ON COLUMN SYS_ORGANIZATION.CONTACT_PHONE IS
'机构联系电话';

COMMENT ON COLUMN SYS_ORGANIZATION.CONTACT_EMAIL IS
'机构联系邮箱';

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
'系统角色信息';

COMMENT ON COLUMN SYS_ROLE.ID IS
'角色主键';

COMMENT ON COLUMN SYS_ROLE.CODE IS
'角色编码 用于进行快速查到下级角色 更改上级时,同步更新所有关联的下级角色编码的上级信息
编码规则4+4+4+4';

COMMENT ON COLUMN SYS_ROLE.NAME IS
'角色名称';

COMMENT ON COLUMN SYS_ROLE.PARENT_ID IS
'上级角色ID';

COMMENT ON COLUMN SYS_ROLE.STATUS IS
'角色状态 0 停用 1 启用';

COMMENT ON COLUMN SYS_ROLE.DESCRIPTION IS
'角色描述';

COMMENT ON COLUMN SYS_ROLE.CREATE_DATE IS
'创建时间';

COMMENT ON COLUMN SYS_ROLE.CREATE_ACCOUNT_ID IS
'创建操作账号';

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
'角色菜单信息';

COMMENT ON COLUMN SYS_ROLE_MENU.ROLE_ID IS
'角色Id';

COMMENT ON COLUMN SYS_ROLE_MENU.MENU_ID IS
'菜单ID';

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
'系统菜单信息';

COMMENT ON COLUMN SYS_MENU.PATH IS
'菜单Url';

COMMENT ON COLUMN SYS_MENU.NAME IS
'菜单名称';

COMMENT ON COLUMN SYS_MENU.ICON IS
'菜单图标';

COMMENT ON COLUMN SYS_MENU.STATUS IS
'菜单状态 0 停用 1 启用';

COMMENT ON COLUMN SYS_MENU.PARENT_ID IS
'上级菜单Id';

COMMENT ON COLUMN SYS_MENU.TYPE IS
'菜单类型   0 目录 1 菜单 2 按钮';

COMMENT ON COLUMN SYS_MENU.ORDER_INDEX IS
'菜单排序索引';

COMMENT ON COLUMN SYS_MENU.BREAD_CRUMB IS
'菜单面包屑';

COMMENT ON COLUMN SYS_MENU.AUTHORITY IS
'Shiro权限标识';

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

