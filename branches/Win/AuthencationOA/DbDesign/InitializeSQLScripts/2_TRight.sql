INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户组管理', '菜单项', 'menu', '/GroupMana/showGroups.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户组管理', '用户组列表', 'path', '/GroupMana/showGroups.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户组管理', '添加组页面', 'path', '/GroupMana/addGroupinit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户组管理', '添加组保存', 'path', '/GroupMana/addGroup.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户组管理', '删除组', 'path', '/GroupMana/delGroup.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户组管理', '设定组用户页面', 'path', '/GroupMana/setGroupUserinit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户组管理', '设定组用户', 'path', '/GroupMana/setGroupUser.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户组管理', '设定组权限页面', 'path', '/GroupMana/setGroupRightinit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户组管理', '设定组权限', 'path', '/GroupMana/setGroupRight.do');


INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '权限管理', '菜单项', 'menu', '/RightMana/showRights.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '权限管理', '权限列表', 'path', '/RightMana/showRights.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '权限管理', '添加权限页面', 'path', '/RightMana/addRightinit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '权限管理', '添加权限', 'path', '/RightMana/addRight.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '权限管理', '删除权限', 'path', '/RightMana/delRight.do');


INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '服务端证书注册', '菜单项', 'menu', '/ServerCer/initServerCerReg.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '服务端证书注册', '服务端证书注册页面', 'path', '/ServerCer/initServerCerReg.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '服务端证书注册', '服务端证书注册', 'path', '/ServerCer/serverCerReg.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '服务端证书搜索', '服务端证书搜索', 'menu', '/ServerCer/showCerReg.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '服务端证书搜索', '服务端证书搜索', 'path', '/ServerCer/showCerReg.do');


INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户管理', '菜单项', 'menu', '/ClientCer/searchUser.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户管理', '用户列表', 'path', '/ClientCer/searchUser.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户管理', '审核用户', 'path', '/ClientCer/verifyUser.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '用户管理', '删除用户', 'path', '/ClientCer/deleteUser.do');


INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '个人证书下载', '菜单项', 'menu', '/ClientCer/initDownloadCer.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '个人证书下载', '展示个人证书信息', 'path', '/ClientCer/initDownloadCer.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '个人证书下载', '下载个人证书', 'path', '/ClientCer/DownloadCer.do');


INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请', '菜单项', 'menu', '/ConferenceMana/searchConference.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请', '查询会议申请', 'path', '/ConferenceMana/searchConference.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请', '申请会议页面', 'path', '/ConferenceMana/initApply.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请', '提交申请', 'path', '/ConferenceMana/submitApply.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请', '查看会议申请', 'path', '/ConferenceMana/viewApply.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请', '会议申请编辑页面', 'path', '/ConferenceMana/initEditApply.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议申请', '保存编辑后的会议申请', 'path', '/ConferenceMana/editApply.do');


INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议审核', '菜单项', 'menu', '/ConferenceMana/adminSearchConference.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议审核', '查看待审核会议申请列表', 'path', '/ConferenceMana/adminSearchConference.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议审核', '查看待审会议申请详情', 'path', '/ConferenceMana/adminviewApply.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '会议审核', '审核会议申请', 'path', '/ConferenceMana/adminVerifyConference.do');


INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '系统日志', '菜单项', 'menu', '/Monitor/monitorShowInit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '系统日志', '初始页面', 'path', '/Monitor/monitorShowInit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '系统日志', '查询', 'path', '/Monitor/monitorShow.do');


INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '菜单项', 'menu', '/Document/documentShowType.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '公文类型列表', 'path', '/Document/documentShowType.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '公文类型添加页面', 'path', '/Document/documentTypeinit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '创建公文类型', 'path', '/Document/documentTypeAdd.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '修改公文类型页面', 'path', '/Document/documentTypeEditInit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '更新公文类型', 'path', '/Document/documentTypeEdit.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文类型配置', '删除公文类型', 'path', '/Document/documentTypeDelete.do');


INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '菜单项', 'menu', '/Document/documentCenter.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '公文流转中心', 'path', '/Document/documentCenter.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '菜单树', 'path', '/documentTree.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '创建文档', 'path', '/Document/createDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '保存文档', 'path', '/Document/saveDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '显示我创建的文档', 'path', '/Document/showCreatedDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '查看文档明细', 'path', '/Document/viewDocDetail.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '公文附件下载', 'path', '/Document/documentDownload.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '公文修改', 'path', '/Document/modifyDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '保存修改后的文档', 'path', '/Document/updateDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '显示待审核公文', 'path', '/Document/showPendingDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '审核公文', 'path', '/Document/auditDocument.do');
INSERT INTO dbo.TRight (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '公文流转', '显示审核过的公文', 'path', '/Document/showAuditedDocument.do');

INSERT INTO dbo.tright (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '非法访问统计', '菜单项', 'menu', '/IllegalAccess/illegalAccessInit.do');
INSERT INTO dbo.tright (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '非法访问统计', '初始界面', 'path', '/IllegalAccess/illegalAccessInit.do');
INSERT INTO dbo.tright (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '非法访问统计', '生成条状图', 'path', '/IllegalAccess/illegalAccessShowCata.do');
INSERT INTO dbo.tright (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '非法访问统计', '生成饼状图', 'path', '/IllegalAccess/illegalAccessShowPie.do');
INSERT INTO dbo.tright (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '非法访问统计', '查看详细记录', 'path', '/IllegalAccess/illegalAccessShowDetail.do');
INSERT INTO dbo.tright (parent_tr_id, right_name, right_desc, right_type, right_path) VALUES (NULL, '非法访问统计', '输出统计图', 'path', '/IllegalAccess/ChartView.do');
