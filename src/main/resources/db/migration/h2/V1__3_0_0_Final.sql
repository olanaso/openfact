
    create table boleta_pe (
       id varchar(255) not null,
        cdr_file_id varchar(255),
        cliente_direccion varchar(255),
        cliente_email varchar(255),
        cliente_nombre varchar(255),
        cliente_numero_documento varchar(255),
        cliente_tipo_documento varchar(255),
        enviar_cliente char(255),
        enviar_sunat char(255),
        estado varchar(255) not null,
        estado_descripcion varchar(255),
        fecha_emision timestamp,
        fecha_vencimiento timestamp,
        file_id varchar(255),
        igv decimal(19,2),
        isc decimal(19,2),
        moneda varchar(255),
        tipo_cambio decimal(19,2),
        observaciones varchar(255),
        total_descuento_global decimal(19,2),
        total_otros_cargos decimal(19,2),
        total_pagar decimal(19,2),
        total_exonerado decimal(19,2),
        total_gratuito decimal(19,2),
        total_gravado decimal(19,2),
        total_inafecto decimal(19,2),
        created_at timestamp,
        numero integer not null,
        serie varchar(255) not null,
        version integer,
        organization_id varchar(255) not null,
        primary key (id)
    );

    create table cn_document (
       id varchar(36) not null,
        amount double,
        assigned_id varchar(255) not null,
        currency varchar(255),
        customer_assigned_id varchar(255),
        customer_name varchar(255),
        issue_date timestamp,
        supplier_assigned_id varchar(255) not null,
        supplier_name varchar(255) not null,
        tax double,
        type varchar(255) not null,
        primary key (id)
    );

    create table component (
       id varchar(36) not null,
        name varchar(255),
        parent_id varchar(255),
        provider_id varchar(255),
        provider_type varchar(255),
        sub_type varchar(255),
        organization_id varchar(255) not null,
        primary key (id)
    );

    create table component_config (
       id varchar(36) not null,
        name varchar(255),
        value varchar(4000),
        component_id varchar(36),
        primary key (id)
    );

    create table comprobante_pago_detalle (
       tipo_documento varchar(31) not null,
        id varchar(255) not null,
        cantidad decimal(13,3) not null,
        descripcion varchar(255) not null,
        precio_unitario decimal(12,2) not null,
        subtotal decimal(12,2) not null,
        tipo_igv varchar(255) not null,
        total decimal(12,2) not null,
        total_igv decimal(12,2) not null,
        total_isc decimal(12,2),
        unidad_medida varchar(255) not null,
        valor_unitario decimal(12,2) not null,
        factura_id varchar(255),
        boleta_id varchar(255),
        primary key (id)
    );

    create table envio_sunat_event (
       tipo_documento varchar(31) not null,
        id varchar(255) not null,
        codigo_respuesta varchar(255) not null,
        descripcion_respuesta varchar(255) not null,
        fecha_envio timestamp not null,
        boleta_id varchar(255),
        factura_id varchar(255),
        primary key (id)
    );

    create table factura_pe (
       id varchar(255) not null,
        cdr_file_id varchar(255),
        cliente_direccion varchar(255),
        cliente_email varchar(255),
        cliente_nombre varchar(255),
        cliente_numero_documento varchar(255),
        cliente_tipo_documento varchar(255),
        enviar_cliente char(255),
        enviar_sunat char(255),
        estado varchar(255) not null,
        estado_descripcion varchar(255),
        fecha_emision timestamp,
        fecha_vencimiento timestamp,
        file_id varchar(255),
        igv decimal(19,2),
        isc decimal(19,2),
        moneda varchar(255),
        tipo_cambio decimal(19,2),
        observaciones varchar(255),
        total_descuento_global decimal(19,2),
        total_otros_cargos decimal(19,2),
        total_pagar decimal(19,2),
        total_exonerado decimal(19,2),
        total_gratuito decimal(19,2),
        total_gravado decimal(19,2),
        total_inafecto decimal(19,2),
        created_at timestamp,
        numero integer not null,
        serie varchar(255) not null,
        version integer,
        organization_id varchar(255) not null,
        primary key (id)
    );

    create table file (
       filename varchar(255) not null,
        bytes blob,
        primary key (filename)
    );

    create table informacion_adicional_pe (
       additional_assigned_id varchar(255),
        assigned_id varchar(255),
        codigo_pais varchar(255),
        codigo_postal varchar(255),
        direccion varchar(255),
        distrito varchar(255),
        nombre_comercial varchar(255),
        provincia varchar(255),
        razon_social varchar(255),
        region varchar(255),
        version integer,
        organizacion_id varchar(255) not null,
        primary key (organizacion_id)
    );

    create table informacion_sunat_pe (
       boleta_factura_endpoint varchar(255),
        consulta_cdr_endpoint varchar(255),
        consulta_factura_endpoint varchar(255),
        guia_remision_enpoint varchar(255),
        password varchar(255),
        retencion_percepcion_endpoint varchar(255),
        use_custom_config char(255) not null,
        usuario varchar(255),
        version integer,
        organizacion_id varchar(255) not null,
        primary key (organizacion_id)
    );

    create table memberships (
       id varchar(255) not null,
        created_on timestamp,
        version integer,
        organization_id varchar(255),
        role_id varchar(255),
        user_id varchar(255),
        primary key (id)
    );

    create table nota_credito_pe (
       cliente_direccion varchar(255),
        cliente_email varchar(255),
        cliente_nombre varchar(255),
        cliente_numero_documento varchar(255),
        cliente_tipo_documento varchar(255),
        id_asignado varchar(255) not null,
        version integer,
        organizacion_id varchar(255) not null,
        primary key (organizacion_id)
    );

    create table nota_debito_pe (
       cliente_direccion varchar(255),
        cliente_email varchar(255),
        cliente_nombre varchar(255),
        cliente_numero_documento varchar(255),
        cliente_tipo_documento varchar(255),
        id_asignado varchar(255) not null,
        version integer,
        organizacion_id varchar(255) not null,
        primary key (organizacion_id)
    );

    create table organization (
       id varchar(255) not null,
        description varchar(255),
        name varchar(255) not null,
        time_zone varchar(255) not null,
        type varchar(255) not null,
        use_custom_certificates char(255) not null,
        use_custom_smtp_config char(255) not null,
        version integer,
        primary key (id)
    );

    create table organization_smtp_config (
       organization_id varchar(255) not null,
        VALUE varchar(255),
        NAME varchar(255) not null,
        primary key (organization_id, NAME)
    );

    create table permissions (
       role_id varchar(255) not null,
        permissions integer
    );

    create table roles (
       id varchar(255) not null,
        auto_grant boolean,
        created_on timestamp,
        description varchar(512),
        name varchar(255),
        primary key (id)
    );

    create table users (
       id varchar(255) not null,
        email varchar(255),
        full_name varchar(255),
        identity_id varchar(255) not null,
        identity_provider varchar(255) not null,
        joined_on timestamp not null,
        username varchar(255) not null,
        version integer,
        primary key (id)
    );

    alter table boleta_pe
       add constraint UK6v5v75beibgmv8kuff2j6m2rv unique (serie, numero, organization_id);

    alter table cn_document
       add constraint UKawubnbop2ucyh7b4ty92y1u76 unique (type, assigned_id, supplier_assigned_id);

    alter table factura_pe
       add constraint UK5xmtr335y1m12safapoiws3g7 unique (serie, numero, organization_id);

    alter table memberships
       add constraint UKidamvecwj5pj5timgjyy8pq79 unique (user_id, role_id, organization_id);

    alter table organization
       add constraint UK8j5y8ipk73yx2joy9yr653c9t unique (name);

    alter table roles
       add constraint UKofx66keruapi6vyqpv6f2or37 unique (name);

    alter table users
       add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);

    alter table users
       add constraint UK19vywygog85fl7f6t9dstiga8 unique (identity_id);

    alter table boleta_pe
       add constraint FKrk56tnwaxn7jdxvsgxvy30k2e
       foreign key (organization_id)
       references organization;

    alter table component
       add constraint FKmpfdha5eg9fm6ht2ue01ec9l6
       foreign key (organization_id)
       references organization;

    alter table component_config
       add constraint FK30o84r8uoxnh7wlbkw1a5mqje
       foreign key (component_id)
       references component;

    alter table comprobante_pago_detalle
       add constraint FKhludft0w1qrh126ra84k1ff0n
       foreign key (factura_id)
       references factura_pe;

    alter table comprobante_pago_detalle
       add constraint FKn33sdvallftn2wknt18ylntv1
       foreign key (boleta_id)
       references boleta_pe;

    alter table envio_sunat_event
       add constraint FK8l9c21lftigmyi4bre9pfvldy
       foreign key (boleta_id)
       references boleta_pe;

    alter table envio_sunat_event
       add constraint FKbhc0v5n4f76c6k6tbtw308hwp
       foreign key (factura_id)
       references factura_pe;

    alter table factura_pe
       add constraint FK9oschd9swwx4u57m0di53x459
       foreign key (organization_id)
       references organization;

    alter table informacion_adicional_pe
       add constraint FKjw1qpna40ge2gmq7512fjknqn
       foreign key (organizacion_id)
       references organization;

    alter table informacion_sunat_pe
       add constraint FK1igxc21l6ydyi4phtp794ts1x
       foreign key (organizacion_id)
       references organization;

    alter table memberships
       add constraint FKp778ik4pdu8wu3hra61aw2ufg
       foreign key (organization_id)
       references organization;

    alter table memberships
       add constraint FKokckx6lcp3k4fwe6qqc621jsp
       foreign key (role_id)
       references roles;

    alter table memberships
       add constraint FKdjormybfoo7f4i4d4r803qohb
       foreign key (user_id)
       references users;

    alter table nota_credito_pe
       add constraint FK38y1ruc1lo5fiq1ldafos367c
       foreign key (organizacion_id)
       references organization;

    alter table nota_debito_pe
       add constraint FK4w3j0mxg0vnuqlrvmt4tc0kc
       foreign key (organizacion_id)
       references organization;

    alter table organization_smtp_config
       add constraint FK3mxpb3h5ubslswet02l5uf04m
       foreign key (organization_id)
       references organization;

    alter table permissions
       add constraint FKmvliun0ngpho0bltt7j6ycqgc
       foreign key (role_id)
       references roles;