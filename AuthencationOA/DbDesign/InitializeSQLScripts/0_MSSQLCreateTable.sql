/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2000                    */
/* Created on:     2009/8/10 23:39:13                           */
/*==============================================================*/


if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ConferenceApply') and o.name = 'FK_CONFEREN_REFERENCE_VCUSTOME0')
alter table ConferenceApply
   drop constraint FK_CONFEREN_REFERENCE_VCUSTOME0
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ConferenceApply') and o.name = 'FK_CONFEREN_REFERENCE_VCUSTOME1')
alter table ConferenceApply
   drop constraint FK_CONFEREN_REFERENCE_VCUSTOME1
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ConferenceApply') and o.name = 'FK_CONFEREN_REFERENCE_TGROUP')
alter table ConferenceApply
   drop constraint FK_CONFEREN_REFERENCE_TGROUP
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TGroupRightRelation') and o.name = 'FK_TGROUPRI_REFERENCE_TGROUP')
alter table TGroupRightRelation
   drop constraint FK_TGROUPRI_REFERENCE_TGROUP
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TGroupRightRelation') and o.name = 'FK_TGROUPRI_REFERENCE_TRIGHT')
alter table TGroupRightRelation
   drop constraint FK_TGROUPRI_REFERENCE_TRIGHT
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TUserGroupRelation') and o.name = 'FK_TUSERGRO_REFERENCE_TGROUP')
alter table TUserGroupRelation
   drop constraint FK_TUSERGRO_REFERENCE_TGROUP
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TUserGroupRelation') and o.name = 'FK_TUSERGRO_REFERENCE_VCUSTOME')
alter table TUserGroupRelation
   drop constraint FK_TUSERGRO_REFERENCE_VCUSTOME
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('document') and o.name = 'FK_DOCUMENT_REFERENCE_DOCUMENTTYPE')
alter table document
   drop constraint FK_DOCUMENT_REFERENCE_DOCUMENTTYPE
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('document') and o.name = 'FK_DOCUMENT_REFERENCE_VCUSTOME')
alter table document
   drop constraint FK_DOCUMENT_REFERENCE_VCUSTOME
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('documentpath') and o.name = 'FK_DOCUMENT_REFERENCE_TGROUP')
alter table documentpath
   drop constraint FK_DOCUMENT_REFERENCE_TGROUP
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('documentpath') and o.name = 'FK_DOCUMENTPATH_REFERENCE_VCUSTOME')
alter table documentpath
   drop constraint FK_DOCUMENTPATH_REFERENCE_VCUSTOME
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('documentpath') and o.name = 'FK_DOCUMENTPATH_REFERENCE_DOCUMENTTYPE')
alter table documentpath
   drop constraint FK_DOCUMENTPATH_REFERENCE_DOCUMENTTYPE
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('documentverify') and o.name = 'FK_DOCUMENTVERIFY_REFERENCE_DOCUMENT')
alter table documentverify
   drop constraint FK_DOCUMENTVERIFY_REFERENCE_DOCUMENT
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('documentverify') and o.name = 'FK_DOCUMENTVERIFY_REFERENCE_VCUSTOME')
alter table documentverify
   drop constraint FK_DOCUMENTVERIFY_REFERENCE_VCUSTOME
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('IllegalAccess') and o.name = 'FK_ILLEGALA_REFERENCE_VCUSTOME')
alter table IllegalAccess
   drop constraint FK_ILLEGALA_REFERENCE_VCUSTOME
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('IllegalAccess') and o.name = 'FK_ILLEGALA_REFERENCE_TRIGHT')
alter table IllegalAccess
   drop constraint FK_ILLEGALA_REFERENCE_TRIGHT
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('moniter') and o.name = 'FK_MONITER_REFERENCE_VCUSTOME')
alter table moniter
   drop constraint FK_MONITER_REFERENCE_VCUSTOME
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AssetApply')
            and   type = 'U')
   drop table AssetApply
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ConferenceApply')
            and   type = 'U')
   drop table ConferenceApply
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TGroup')
            and   type = 'U')
   drop table TGroup
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TGroupRightRelation')
            and   type = 'U')
   drop table TGroupRightRelation
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TRight')
            and   type = 'U')
   drop table TRight
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TUser')
            and   type = 'U')
   drop table TUser
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TUserGroupRelation')
            and   type = 'U')
   drop table TUserGroupRelation
go

if exists (select 1
            from  sysobjects
           where  id = object_id('certificatereg')
            and   type = 'U')
   drop table certificatereg
go

if exists (select 1
            from  sysobjects
           where  id = object_id('document')
            and   type = 'U')
   drop table document
go

if exists (select 1
            from  sysobjects
           where  id = object_id('documentpath')
            and   type = 'U')
   drop table documentpath
go

if exists (select 1
            from  sysobjects
           where  id = object_id('documenttype')
            and   type = 'U')
   drop table documenttype
go

if exists (select 1
            from  sysobjects
           where  id = object_id('documentverify')
            and   type = 'U')
   drop table documentverify
go

if exists (select 1
            from  sysobjects
           where  id = object_id('IllegalAccess')
            and   type = 'U')
   drop table IllegalAccess
go

if exists (select 1
            from  sysobjects
           where  id = object_id('moniter')
            and   type = 'U')
   drop table moniter
go

if exists (select 1
            from  sysobjects
           where  id = object_id('rcustomer')
            and   type = 'U')
   drop table rcustomer
go

if exists (select 1
            from  sysobjects
           where  id = object_id('vcustomer')
            and   type = 'U')
   drop table vcustomer
go

/*==============================================================*/
/* Table: AssetApply                                            */
/*==============================================================*/
create table AssetApply (
   numapplyid           int                  identity(1,1),
   vc2assetname         varchar(200)         not null,
   numstockcount        int                  not null,
   numunitprice         int                  not null,
   numtotalcount        int                  not null,
   vc2status            varchar(1)           not null,
   vc2txtinfo           varchar(500)         null,
   numapplierid         int                  null,
   numverifierid        int                  null,
   constraint PK_ASSETAPPLY primary key (numapplyid)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description',
   'P:待审核,Y:审核通过未采购,N:审核未通过,B:进行时;O:已完成',
   'user', @CurrentUser, 'table', 'AssetApply', 'column', 'vc2status'
go

/*==============================================================*/
/* Table: ConferenceApply                                       */
/*==============================================================*/
create table ConferenceApply (
   numapplyid           int                  identity(1,1),
   numapplierid         int                  null,
   numverifierid        int                  null,
   tg_id                int                  not null,
   vc2name              varchar(100)         not null,
   vc2desc              varchar(1000)        null,
   datbegintime         datetime             not null,
   datendtime           datetime             not null,
   vc2status            varchar(1)           not null,
   vc2txtinfo           varchar(500)         null,
   constraint PK_CONFERENCEAPPLY primary key (numapplyid)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description',
   'P:待审核,Y:审核通过未开始,N:审核未通过,B:进行时;O:已结束',
   'user', @CurrentUser, 'table', 'ConferenceApply', 'column', 'vc2status'
go

/*==============================================================*/
/* Table: TGroup                                                */
/*==============================================================*/
create table TGroup (
   tg_id                int                  identity(1,1),
   group_name           varchar(64)          not null,
   parent_tg_id         int                  null,
   gen_time             datetime             not null,
   tg_desc              varchar(200)         null,
   constraint PK_TGROUP primary key nonclustered (tg_id)
)
go

/*==============================================================*/
/* Table: TGroupRightRelation                                   */
/*==============================================================*/
create table TGroupRightRelation (
   tg_id                int                  null,
   tr_id                int                  null
)
go

/*==============================================================*/
/* Table: TRight                                                */
/*==============================================================*/
create table TRight (
   tr_id                int                  identity(1,1),
   parent_tr_id         int                  null,
   right_name           varchar(64)          not null,
   right_desc           varchar(200)         null,
   right_type           varchar(45)          not null,
   right_path           varchar(1000)        not null,
   constraint PK_TRIGHT primary key nonclustered (tr_id)
)
go

/*==============================================================*/
/* Table: TUser                                                 */
/*==============================================================*/
create table TUser (
   tu_id                int                  identity(1,1),
   name                 varchar(64)          not null,
   email                varchar(500)         not null,
   password             varchar(64)          not null,
   gen_time             datetime             not null,
   login_time           datetime             null,
   last_login_time      datetime             null,
   count                int                  not null,
   constraint PK_TUSER primary key nonclustered (tu_id)
)
go

/*==============================================================*/
/* Table: TUserGroupRelation                                    */
/*==============================================================*/
create table TUserGroupRelation (
   tg_id                int                  null,
   userid               int                  null
)
go

/*==============================================================*/
/* Table: certificatereg                                        */
/*==============================================================*/
create table certificatereg (
   ksdid                int                  identity(1,1),
   name                 varchar(50)          null,
   departname           varchar(50)          null,
   oname                varchar(50)          null,
   cname                varchar(50)          null,
   pname                varchar(50)          null,
   ctname               varchar(50)          null,
   ctfname              varchar(50)          null,
   albyte               numeric              null,
   cpass                varchar(50)          null,
   ppass                varchar(50)          null,
   location             varchar(50)          null,
   dday                 numeric              null,
   ddaybeg              datetime             null,
   ddayover             datetime             null,
   constraint PK_CERTIFICATEREG primary key (ksdid)
)
go

/*==============================================================*/
/* Table: document                                              */
/*==============================================================*/
create table document (
   numdocid             int                  identity(1,1),
   numtypeid            int                  null,
   vc2title             varchar(50)          null,
   vc2content           varchar(2000)        null,
   vc2addition          varchar(50)          null,
   vc2additionname      varchar(200)         null,
   userid               int                  null,
   lockuserid           int                  null,
   vc2lock              char(1)              null,
   vc2result            char(1)              null,
   vc2use               char(1)              null,
   datcreatetime        datetime             null,
   numcurrstep          int                  null,
   constraint PK_DOCUMENT primary key (numdocid)
)
go

/*==============================================================*/
/* Table: documentpath                                          */
/*==============================================================*/
create table documentpath (
   numpathid            int                  identity(1,1),
   numdoctypeid         int                  not null,
   numstepindex         int                  not null,
   tg_id                int                  null,
   userid               int                  null,
   chverifiertype       char(1)              not null,
   vc2stepdesc          varchar(2000)        null,
   constraint PK_DOCUMENTPATH primary key (numpathid)
)
go

/*==============================================================*/
/* Table: documenttype                                          */
/*==============================================================*/
create table documenttype (
   numtypeid            int                  identity(1,1),
   vc2name              varchar(50)          null,
   constraint PK_DOCUMENTTYPE primary key (numtypeid)
)
go

/*==============================================================*/
/* Table: documentverify                                        */
/*==============================================================*/
create table documentverify (
   numverifyid          int                  identity(1,1),
   numdocid             int                  null,
   userid               int                  null,
   chresult             char(1)              null,
   vc2message           varchar(2000)        null,
   dattime              datetime             null,
   numstepindex         int                  null,
   constraint PK_DOCUMENTVERIFY primary key (numverifyid)
)
go

/*==============================================================*/
/* Table: IllegalAccess                                         */
/*==============================================================*/
create table IllegalAccess (
   numilgacsid          int                  identity(1,1),
   userid               int                  null,
   tr_id                int                  not null,
   dataccesstime        datetime             not null,
   constraint PK_ILLEGALACCESS primary key (numilgacsid)
)
go

/*==============================================================*/
/* Table: moniter                                               */
/*==============================================================*/
create table moniter (
   nummoniterid         int                  identity(1,1),
   userid               int                  not null,
   dattime              datetime             not null,
   vc2path              varchar(200)         not null,
   vc2parameter         varchar(2000)        not null,
   vc2exception         varchar(2000)        null,
   constraint PK_MONITER primary key (nummoniterid)
)
go

/*==============================================================*/
/* Table: rcustomer                                             */
/*==============================================================*/
create table rcustomer (
   userid               int                  identity(1,1),
   name                 varchar(64)          not null,
   departname           varchar(64)          not null,
   oname                varchar(64)          not null,
   cname                varchar(64)          not null,
   pname                varchar(64)          not null,
   ctname               varchar(64)          not null,
   dday                 varchar(64)          not null,
   ddaybeg              datetime             not null,
   ddayover             datetime             not null,
   password             varchar(64)          not null,
   constraint PK_RCUSTOMER primary key nonclustered (userid)
)
go

/*==============================================================*/
/* Table: vcustomer                                             */
/*==============================================================*/
create table vcustomer (
   userid               int                  identity(1,1),
   name                 varchar(64)          not null,
   departname           varchar(64)          not null,
   oname                varchar(64)          not null,
   cname                varchar(64)          not null,
   pname                varchar(64)          not null,
   ctname               varchar(64)          not null,
   dday                 varchar(64)          not null,
   ddaybeg              datetime             not null,
   ddayover             datetime             not null,
   password             varchar(64)          not null,
   verifystatus         varchar(1)           not null,
   enable               varchar(1)           not null,
   constraint PK_VCUSTOMER primary key nonclustered (userid)
)
go

alter table ConferenceApply
   add constraint FK_CONFEREN_REFERENCE_VCUSTOME0 foreign key (numapplierid)
      references vcustomer (userid)
go

alter table ConferenceApply
   add constraint FK_CONFEREN_REFERENCE_VCUSTOME1 foreign key (numverifierid)
      references vcustomer (userid)
go

alter table ConferenceApply
   add constraint FK_CONFEREN_REFERENCE_TGROUP foreign key (tg_id)
      references TGroup (tg_id)
go

alter table TGroupRightRelation
   add constraint FK_TGROUPRI_REFERENCE_TGROUP foreign key (tg_id)
      references TGroup (tg_id)
go

alter table TGroupRightRelation
   add constraint FK_TGROUPRI_REFERENCE_TRIGHT foreign key (tr_id)
      references TRight (tr_id)
go

alter table TUserGroupRelation
   add constraint FK_TUSERGRO_REFERENCE_TGROUP foreign key (tg_id)
      references TGroup (tg_id)
go

alter table TUserGroupRelation
   add constraint FK_TUSERGRO_REFERENCE_VCUSTOME foreign key (userid)
      references vcustomer (userid)
go

alter table document
   add constraint FK_DOCUMENT_REFERENCE_DOCUMENTTYPE foreign key (numtypeid)
      references documenttype (numtypeid)
go

alter table document
   add constraint FK_DOCUMENT_REFERENCE_VCUSTOME foreign key (userid)
      references vcustomer (userid)
go

alter table documentpath
   add constraint FK_DOCUMENT_REFERENCE_TGROUP foreign key (tg_id)
      references TGroup (tg_id)
go

alter table documentpath
   add constraint FK_DOCUMENTPATH_REFERENCE_VCUSTOME foreign key (userid)
      references vcustomer (userid)
go

alter table documentpath
   add constraint FK_DOCUMENTPATH_REFERENCE_DOCUMENTTYPE foreign key (numdoctypeid)
      references documenttype (numtypeid)
go

alter table documentverify
   add constraint FK_DOCUMENTVERIFY_REFERENCE_DOCUMENT foreign key (numdocid)
      references document (numdocid)
go

alter table documentverify
   add constraint FK_DOCUMENTVERIFY_REFERENCE_VCUSTOME foreign key (userid)
      references vcustomer (userid)
go

alter table IllegalAccess
   add constraint FK_ILLEGALA_REFERENCE_VCUSTOME foreign key (userid)
      references vcustomer (userid)
go

alter table IllegalAccess
   add constraint FK_ILLEGALA_REFERENCE_TRIGHT foreign key (tr_id)
      references TRight (tr_id)
go


alter table moniter
   add constraint FK_MONITER_REFERENCE_VCUSTOME foreign key (userid)
      references vcustomer (userid)
go

