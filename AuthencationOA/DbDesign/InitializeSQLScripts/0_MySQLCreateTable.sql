drop table if exists rcustomer;

drop table if exists AssetApply;

drop table if exists TGroupRightRelation;

drop table if exists TUserGroupRelation;

drop table if exists TRight;

drop table if exists documentverify;

drop table if exists document;

drop table if exists documentpath;

drop table if exists documenttype;

drop table if exists ConferenceApply;

drop table if exists certificatereg;

drop table if exists moniter;

drop table if exists vcustomer;

drop table if exists TGroup;

drop table if exists TUser;

/*==============================================================*/
/* Table: AssetApply                                            */
/*==============================================================*/
create table AssetApply
(
   numapplyid           int not null auto_increment,
   vc2assetname         varchar(200) not null,
   numstockcount        int not null,
   numunitprice         int not null,
   numtotalcount        int not null,
   vc2status            varchar(1) not null comment 'P:待审核,Y:审核通过未采购,N:审核未通过,B:进行时;O:已完成',
   vc2txtinfo           varchar(500),
   numapplierid         int,
   numverifierid        int,
   primary key (numapplyid)
);

/*==============================================================*/
/* Table: ConferenceApply                                       */
/*==============================================================*/
create table ConferenceApply
(
   numapplyid           int not null auto_increment,
   numapplierid         int,
   numverifierid        int,
   tg_id                int not null,
   vc2name              varchar(100) not null,
   vc2desc              varchar(1000),
   datbegintime         datetime not null,
   datendtime           datetime not null,
   vc2status            varchar(1) not null comment 'P:待审核,Y:审核通过未开始,N:审核未通过,B:进行时;O:已结束',
   vc2txtinfo           varchar(500),
   primary key (numapplyid)
);

/*==============================================================*/
/* Table: TGroup                                                */
/*==============================================================*/
create table TGroup
(
   tg_id                int not null auto_increment,
   group_name           varchar(64) not null,
   parent_tg_id         int,
   gen_time             datetime not null,
   tg_desc              varchar(200),
   primary key (tg_id)
);

/*==============================================================*/
/* Table: TGroupRightRelation                                   */
/*==============================================================*/
create table TGroupRightRelation
(
   tg_id                int,
   tr_id                int
);

/*==============================================================*/
/* Table: TRight                                                */
/*==============================================================*/
create table TRight
(
   tr_id                int not null auto_increment,
   parent_tr_id         int,
   right_name           varchar(64) not null,
   right_desc           varchar(200),
   right_type           varchar(45) not null,
   right_path           varchar(1000) not null,
   primary key (tr_id)
);

/*==============================================================*/
/* Table: TUser                                                 */
/*==============================================================*/
create table TUser
(
   tu_id                int not null auto_increment,
   name                 varchar(64) not null,
   email                varchar(500) not null,
   password             varchar(64) not null,
   gen_time             datetime not null,
   login_time           datetime,
   last_login_time      datetime,
   count                int not null,
   primary key (tu_id)
);

/*==============================================================*/
/* Table: TUserGroupRelation                                    */
/*==============================================================*/
create table TUserGroupRelation
(
   tg_id                int,
   userid               int
);

/*==============================================================*/
/* Table: certificatereg                                        */
/*==============================================================*/
create table certificatereg
(
   ksdid                int not null auto_increment,
   name                 varchar(50),
   departname           varchar(50),
   oname                varchar(50),
   cname                varchar(50),
   pname                varchar(50),
   ctname               varchar(50),
   ctfname              varchar(50),
   albyte               numeric(8,0),
   cpass                varchar(50),
   ppass                varchar(50),
   location             varchar(50),
   dday                 numeric(8,0),
   ddaybeg              datetime,
   ddayover             datetime,
   primary key (ksdid)
);

/*==============================================================*/
/* Table: document                                              */
/*==============================================================*/
create table document
(
   numdocid             int not null auto_increment,
   numtypeid            int,
   vc2title             varchar(50),
   vc2content           varchar(2000),
   vc2addition          varchar(50),
   vc2additionname      varchar(200),
   userid               int,
   vc2lock              char(1),
   vc2result            char(1),
   vc2use               char(1),
   datcreatetime        datetime,
   numcurrstep          int,
   primary key (numdocid)
);

/*==============================================================*/
/* Table: documentpath                                          */
/*==============================================================*/
create table documentpath
(
   numpathid            int not null auto_increment,
   numdoctypeid         int not null,
   numstepindex         int not null,
   tg_id                int,
   userid               int,
   chverifiertype       char(1) not null,
   vc2stepdesc          varchar(2000),
   primary key (numpathid)
);

/*==============================================================*/
/* Table: documenttype                                          */
/*==============================================================*/
create table documenttype
(
   numtypeid            int not null auto_increment,
   vc2name              varchar(50),
   primary key (numtypeid)
);

/*==============================================================*/
/* Table: documentverify                                        */
/*==============================================================*/
create table documentverify
(
   numverifyid          int not null auto_increment,
   numdocid             int,
   userid               int,
   chresult             char(1),
   vc2message           varchar(2000),
   dattime              datetime,
   numstepindex         int,
   primary key (numverifyid)
);

/*==============================================================*/
/* Table: moniter                                               */
/*==============================================================*/
create table moniter
(
   nummoniterid         int not null auto_increment,
   userid               int not null,
   dattime              datetime not null,
   vc2path              varchar(200) not null,
   vc2parameter         varchar(2000) not null,
   vc2exception         varchar(2000),
   primary key (nummoniterid)
);

/*==============================================================*/
/* Table: rcustomer                                             */
/*==============================================================*/
create table rcustomer
(
   userid               int not null auto_increment,
   name                 varchar(64) not null,
   departname           varchar(64) not null,
   oname                varchar(64) not null,
   cname                varchar(64) not null,
   pname                varchar(64) not null,
   ctname               varchar(64) not null,
   dday                 varchar(64) not null,
   ddaybeg              datetime not null,
   ddayover             datetime not null,
   password             varchar(64) not null,
   primary key (userid)
);

/*==============================================================*/
/* Table: vcustomer                                             */
/*==============================================================*/
create table vcustomer
(
   userid               int not null auto_increment,
   name                 varchar(64) not null,
   departname           varchar(64) not null,
   oname                varchar(64) not null,
   cname                varchar(64) not null,
   pname                varchar(64) not null,
   ctname               varchar(64) not null,
   dday                 varchar(64) not null,
   ddaybeg              datetime not null,
   ddayover             datetime not null,
   password             varchar(64) not null,
   verifystatus         varchar(1) not null,
   enable               varchar(1) not null,
   primary key (userid)
);

alter table ConferenceApply add constraint FK_CONFEREN_REFERENCE_VCUSTOME0 foreign key (numapplierid)
      references vcustomer (userid) on delete restrict on update restrict;

alter table ConferenceApply add constraint FK_CONFEREN_REFERENCE_VCUSTOME1 foreign key (numverifierid)
      references vcustomer (userid) on delete restrict on update restrict;

alter table ConferenceApply add constraint FK_Reference_7 foreign key (tg_id)
      references TGroup (tg_id) on delete restrict on update restrict;

alter table TGroupRightRelation add constraint FK_Reference_1 foreign key (tg_id)
      references TGroup (tg_id) on delete restrict on update restrict;

alter table TGroupRightRelation add constraint FK_Reference_2 foreign key (tr_id)
      references TRight (tr_id) on delete restrict on update restrict;

alter table TUserGroupRelation add constraint FK_Reference_3 foreign key (tg_id)
      references TGroup (tg_id) on delete restrict on update restrict;

alter table TUserGroupRelation add constraint FK_Reference_4 foreign key (userid)
      references vcustomer (userid) on delete restrict on update restrict;

alter table document add constraint FK_DOCUMENT_REFERENCE_DOCUMENTTYPE foreign key (numtypeid)
      references documenttype (numtypeid) on delete restrict on update restrict;

alter table document add constraint FK_Reference_12 foreign key (userid)
      references vcustomer (userid) on delete restrict on update restrict;

alter table documentpath add constraint FK_Reference_14 foreign key (tg_id)
      references TGroup (tg_id) on delete restrict on update restrict;

alter table documentpath add constraint FK_DOCUMENTPATH_REFERENCE_VCUSTOME foreign key (userid)
      references vcustomer (userid) on delete restrict on update restrict;

alter table documentpath add constraint FK_DOCUMENTPATH_REFERENCE_DOCUMENTTYPE foreign key (numdoctypeid)
      references documenttype (numtypeid) on delete restrict on update restrict;

alter table documentverify add constraint FK_DOCUMENTVERIFY_REFERENCE_DOCUMENT foreign key (numdocid)
      references document (numdocid) on delete restrict on update restrict;

alter table documentverify add constraint FK_DOCUMENTVERIFY_REFERENCE_VCUSTOME foreign key (userid)
      references vcustomer (userid) on delete restrict on update restrict;

alter table moniter add constraint FK_Reference_16 foreign key (userid)
      references vcustomer (userid) on delete restrict on update restrict;
