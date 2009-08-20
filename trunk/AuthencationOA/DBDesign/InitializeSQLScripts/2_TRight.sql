INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户组管理', NULL, 'menu', '/GroupMana/showGroups.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '权限管理', NULL, 'menu', '/RightMana/showRights.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '服务端证书注册', '', 'menu', '/ServerCer/initServerCerReg.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '服务端证书注册initServerCerReg', '', 'path', '/ServerCer/initServerCerReg.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '服务端证书搜索', '', 'menu', '/ServerCer/showCerReg.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户管理', '', 'menu', '/ClientCer/searchUser.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户管理searchUser', '', 'path', '/ClientCer/searchUser.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户管理deleteUser', '', 'path', '/ClientCer/deleteUser.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '个人证书下载initDownloadCer', '', 'path', '/ClientCer/initDownloadCer.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '个人证书下载DownloadCer', '', 'path', '/ClientCer/DownloadCer.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请searchConference', '', 'path', '/ConferenceMana/searchConference.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请submitApply', '', 'path', '/ConferenceMana/submitApply.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请viewApply', '', 'path', '/ConferenceMana/viewApply.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请editApply', '', 'path', '/ConferenceMana/editApply.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议审核adminSearchConference', '', 'path', '/ConferenceMana/adminSearchConference.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议审核adminviewApply', '', 'path', '/ConferenceMana/adminviewApply.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '服务端证书注册serverCerReg', '', 'path', '/ServerCer/serverCerReg.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '服务端证书搜索', '', 'path', '/ServerCer/showCerReg.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户管理verifyUser', '', 'path', '/ClientCer/verifyUser.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '个人证书下载', '', 'menu', '/ClientCer/initDownloadCer.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请', '', 'menu', '/ConferenceMana/searchConference.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请initApply', '', 'path', '/ConferenceMana/initApply.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请initEditApply', '', 'path', '/ConferenceMana/initEditApply.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议审核', '', 'menu', '/ConferenceMana/adminSearchConference.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议审核adminVerifyConference', '', 'path', '/ConferenceMana/adminVerifyConference.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '系统日志', '', 'menu', '/Monitor/monitorShowInit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '系统日志', '初始页面', 'path', '/Monitor/monitorShowInit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '系统日志', '查询', 'path', '/Monitor/monitorShow.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '', 'menu', '/Document/documentShowType.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '公文类型添加页面', 'path', '/Document/documentTypeinit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '创建公文类型', 'path', '/Document/documentTypeAdd.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '修改公文类型页面', 'path', '/Document/documentTypeEditInit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '更新公文类型', 'path', '/Document/documentTypeEdit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '删除公文类型', 'path', '/Document/documentTypeDelete.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '公文类型列表', 'path', '/Document/documentShowType.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '公文流转', 'menu', '/Document/documentCenter.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '公文流转中心', 'path', '/Document/documentCenter.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '菜单树', 'path', '/documentTree.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '创建文档', 'path', '/Document/createDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '保存文档', 'path', '/Document/saveDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '显示我创建的文档', 'path', '/Document/showCreatedDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '查看文档明细', 'path', '/Document/viewDocDetail.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '公文附件下载', 'path', '/Document/documentDownload.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '公文修改', 'path', '/Document/modifyDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '显示待审核公文', 'path', '/Document/showPendingDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '审核公文', 'path', '/Document/auditDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '显示审核过的公文', 'path', '/Document/showAuditedDocument.do');