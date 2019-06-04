create table `case`
(
    PATIENT_ID            varchar(64)  null comment '病人ID',
    CASE_ID               varchar(64)  not null comment '病例号'
        primary key,
    FIRST_DIAGNOSE_DATE   date         null comment '首次就诊时间',
    DIAGNOSE_TIMES        int(10)      null comment '就诊次数',
    BROKEN_TEETH_LOCATION varchar(255) null comment '坏牙位置',
    REASON                varchar(255) null comment '病因',
    PATIENT_SOURCE        varchar(64)  null comment '患者来源',
    PROFESSIONAL          varchar(64)  null comment '职业',
    EATING_HABBIT         varchar(255) null comment '饮食习惯',
    GENETIC_HISTORY       varchar(64)  null comment '遗传病史',
    CULTURE_DEGREE        varchar(64)  null comment '文化程度',
    HEART_DISEASE_HISTORY varchar(32)  null comment '心脏病史',
    DOCTOR_ADVICE         varchar(255) null comment '医嘱',
    CREATE_TIME           datetime     null,
    MODIFY_TIME           datetime     null,
    constraint IDX_PATIENT_ID
        unique (PATIENT_ID)
)
    comment '病例表';

create table case_detail
(
    case_id            int(20)      null comment '病历编号',
    is_baby_teeth      int(5)       null comment '是否为乳牙',
    complaint          varchar(200) null comment '病人主诉',
    medical_history    varchar(200) null comment '既往病史',
    medical_present    varchar(200) null comment '现病史',
    diagnosis          varchar(200) null comment '检查结果',
    reexamination_time date         null comment '复诊时间',
    drug_name          varchar(50)  null comment '药品名称',
    drug_norm          varchar(200) null comment '药品规格',
    drug_quantity      varchar(200) null comment '药品数量',
    drug_cost          varchar(10)  null comment '药品单价',
    drug_usage         varchar(200) null comment '药品用法'
)
    comment '病历详情';

create index caseid
    on case_detail (case_id);

create table case_info
(
    PATIENT_ID            varchar(64)  null comment '病人ID',
    CASE_ID               varchar(64)  not null comment '病例号'
        primary key,
    FIRST_DIAGNOSE_DATE   date         null comment '首次就诊时间',
    DIAGNOSE_TIMES        int(10)      null comment '就诊次数',
    BROKEN_TEETH_LOCATION varchar(255) null comment '坏牙位置 0 1 2 3 上下左右 八颗',
    REASON                varchar(255) null comment '病因 0 细菌 1 口腔环境 2 宿主 3 饮食习惯',
    PATIENT_SOURCE        varchar(64)  null comment '患者来源',
    PROFESSIONAL          varchar(64)  null comment '职业',
    EATING_HABBIT         varchar(255) null comment '饮食习惯',
    GENETIC_HISTORY       varchar(64)  null comment '遗传病史',
    CULTURE_DEGREE        varchar(64)  null comment '文化程度',
    HEART_DISEASE_HISTORY varchar(32)  null comment '心脏病史',
    DOCTOR_ADVICE         varchar(255) null comment '医嘱',
    CREATE_TIME           datetime     null,
    MODIFY_TIME           datetime     null,
    constraint IDX_PATIENT_ID
        unique (PATIENT_ID)
)
    comment '病例表';

create table cluster_info
(
    cluster_id      varchar(64)  not null comment '群号'
        primary key,
    cluster_name    varchar(45)  null comment '群名称',
    cluster_desp    varchar(128) null comment '群描述',
    create_time     datetime     null,
    cluster_pic_url varchar(128) null comment '群头像'
)
    comment '群信息表';

create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;

create table message_content
(
    msg_id           varchar(64)   not null comment 'id'
        primary key,
    msg_content      varchar(1024) null comment '聊天内容',
    msg_from_user_id varchar(45)   null comment '发送方id',
    msg_to_user_id   varchar(45)   null comment '接收方id （msg_flag 若为 1 则接收方id 为群组id）',
    msg_flag         varchar(45)   null comment '群聊标识（1 群聊 2 私聊）',
    msg_send_time    datetime      null comment '发送时间'
)
    comment '聊天记录表';

create table message_user
(
    user_id      varchar(64)  not null
        primary key,
    account_name varchar(45)  null comment '名称',
    password     varchar(45)  null comment '密码',
    cluster_id   varchar(45)  null comment '群id',
    create_time  datetime     null,
    pic_url      varchar(128) null comment '头像地址'
)
    comment '聊天用户表';

create table person
(
    id   bigint       not null
        primary key,
    age  int          not null,
    name varchar(255) not null
)
    engine = MyISAM;

create table person_info
(
    PATIENT_ID   varchar(64) not null comment '病人id'
        primary key,
    PATIENT_NAME varchar(45) null comment '病人姓名',
    PATIENT_SEX  varchar(2)  null comment '病人性别',
    PATIENT_AGE  int         null,
    ROLE_TYPE    varchar(2)  null comment '角色类型:  医生标识01,病人标识00',
    CREATE_TIME  datetime    null,
    MODIFY_TIME  datetime    null
)
    comment '基本信息表';

create table sys_config
(
    id            int auto_increment
        primary key,
    config_status varchar(1)      null comment '状态{0：无效，1：有效}',
    config_key    varchar(200)    not null comment '键',
    config_value  varchar(500)    not null comment '值',
    creater       int             null,
    create_time   datetime        null,
    operator      int             null,
    operate_time  datetime        null,
    remark        varchar(200)    null,
    version       int default '1' null comment '版本号',
    constraint un_config_key
        unique (config_key) comment '唯一约束'
);

create index idx_config_key
    on sys_config (config_status, config_key);

create table sys_dict
(
    ID             int auto_increment comment 'ID'
        primary key,
    DICT_TYPE      varchar(30)  null comment '字典类型',
    DICT_TYPE_NAME varchar(50)  null comment '字典类型名称',
    DICT_NAME      varchar(50)  null comment '字典名称',
    DICT_CODE      varchar(50)  null comment '字典编码',
    DICT_STATUS    char         null comment '状态',
    ORDER_NUM      int          null comment '排序',
    CREATER_TIME   int          null comment '创建人',
    CREATE_TIME    datetime     null comment '创建时间',
    OPERATOR       int          null comment '更改人',
    OPERATE_TIME   datetime     null comment '更改时间',
    VERSION        int          null comment '版本号',
    REMARK         varchar(255) null comment '备注'
)
    comment '系统字典表';

create table sys_permission
(
    id              int auto_increment comment 'ID'
        primary key,
    permission_name varchar(250)    null comment '资源中文名称',
    permission_type varchar(1)      null comment '资源类型{0：系统，1：模块，2：菜单，3：功能}',
    permission_tag  varchar(250)    null comment '权限标识',
    permission_uri  varchar(250)    null comment '资源地址',
    permission_icon varchar(250)    null comment '权限图标',
    parent_id       int(36)         null comment '父节点',
    order_num       int             null comment '排序',
    creater         int             null comment '创建者',
    create_time     datetime        null comment '创建时间',
    operator        int             null comment '修改者',
    operate_time    datetime        null comment '修改时间',
    remark          varchar(200)    null comment '备注',
    version         int default '1' null comment '版本号',
    constraint un_permission_tag
        unique (permission_tag)
)
    comment '系统资源表';

create index idx_permission_tag
    on sys_permission (id, permission_type, permission_tag, parent_id);

create table sys_role
(
    id           int auto_increment comment 'ID'
        primary key,
    role_name    varchar(100)    not null comment '角色名称',
    role_code    varchar(100)    not null comment '角色描述',
    creater      int             null comment '创建者',
    create_time  datetime        null comment '创建时间',
    operator     int             null comment '修改者',
    operate_time datetime        null comment '修改时间',
    remark       varchar(200)    null comment '备注',
    version      int default '1' null comment '版本号',
    constraint un_role_code
        unique (role_code),
    constraint un_role_name
        unique (role_name)
)
    comment '系统角色';

create index idx_system_role
    on sys_role (id, role_code);

create table sys_role_permission_ref
(
    id            int auto_increment comment 'ID'
        primary key,
    role_id       int      not null comment '角色ID',
    permission_id int      not null comment '资源ID',
    creater       int      null comment '创建者',
    create_time   datetime null comment '创建时间'
)
    comment '系统角色和权限关联表';

create index idx_role_permission
    on sys_role_permission_ref (role_id, permission_id);

create table sys_user
(
    id              int auto_increment comment 'ID'
        primary key,
    username        varchar(100)           not null comment '账户',
    password        varchar(36)            not null comment '密码',
    salt_key        varchar(36)            null comment '盐',
    real_name       varchar(100)           not null comment '真实姓名',
    user_code       varchar(20)            null comment '人员编码',
    sex             varchar(1)             null comment '性别{0:男，1：女}',
    card_type       varchar(2) default '1' null comment '证件类型',
    card_no         varchar(18)            null comment '证件号码',
    mobile          varchar(20)            null comment '电话号码',
    email           varchar(50)            null comment '邮箱',
    user_status     varchar(1) default '1' null comment '账号状态{0：禁用，1：可用}',
    last_login_time datetime               null comment '最后登录时间',
    last_login_ip   varchar(50)            null comment '最后登录IP',
    creater         int                    null comment '创建者',
    create_time     datetime               null comment '创建时间',
    operator        int                    null comment '修改者',
    operate_time    datetime               null comment '修改时间',
    remark          varchar(200)           null comment '备注',
    version         int        default '1' null comment '版本号',
    constraint un_user_code
        unique (user_code),
    constraint un_user_name
        unique (username)
)
    comment '系统用户';

create table sys_user_role_ref
(
    id          int auto_increment comment 'ID'
        primary key,
    user_id     int      not null comment '用户ID',
    role_id     int      not null comment '角色ID',
    creater     int      null comment '创建者',
    create_time datetime null comment '创建时间'
)
    comment '系统组织和角色关联表';

create index idx_role_user
    on sys_user_role_ref (user_id, role_id);

create table user
(
    name varchar(32) not null
        primary key,
    age  int         null
)
    comment '用户表';

