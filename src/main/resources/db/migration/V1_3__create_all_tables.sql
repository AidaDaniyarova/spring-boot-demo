
CREATE TABLE IF NOT EXISTS company
(
    id           serial4      NOT NULL,
    company_name varchar(255) NOT NULL,
    description  varchar(255) NOT NULL,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS country
(
    id           serial4      NOT NULL,
    country_name varchar(255) NOT NULL,
    CONSTRAINT country_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS flyway_schema_history
(
    installed_rank int4                    NOT NULL,
    "version"      varchar(50) NULL,
    description    varchar(200)            NOT NULL,
    "type"         varchar(20)             NOT NULL,
    script         varchar(1000)           NOT NULL,
    checksum       int4 NULL,
    installed_by   varchar(100)            NOT NULL,
    installed_on   timestamp DEFAULT now() NOT NULL,
    execution_time int4                    NOT NULL,
    success        bool                    NOT NULL,
    CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank)
);



CREATE TABLE IF NOT EXISTS gender
(
    id     serial4 NOT NULL,
    "name" bpchar(1) NOT NULL,
    CONSTRAINT gender_pkey PRIMARY KEY (id)
);



CREATE TABLE IF NOT EXISTS roles
(
    id          serial4      NOT NULL,
    role_name   varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    salary      int4         NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS status
(
    id          serial4 NOT NULL,
    status_name varchar(255) NULL,
    CONSTRAINT status_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS users
(
    id           serial4      NOT NULL,
    first_name   varchar(255) NOT NULL,
    last_name    varchar(255) NOT NULL,
    email        varchar(255) NOT NULL,
    "password"   varchar(255) NOT NULL,
    phone_number varchar(11)  NOT NULL,
    CONSTRAINT users_email_key UNIQUE (email),
    CONSTRAINT users_phone_number_key UNIQUE (phone_number),
    CONSTRAINT users_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS city
(
    id         serial4      NOT NULL,
    city_name  varchar(255) NOT NULL,
    country_id int4         NOT NULL,
    CONSTRAINT city_pkey PRIMARY KEY (id),
    CONSTRAINT city_country_id_fkey FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TABLE IF NOT EXISTS departments
(
    id              serial4      NOT NULL,
    department_name varchar(255) NOT NULL,
    description     varchar(255) NOT NULL,
    employee_number int4 NULL,
    company_id      int4         NOT NULL,
    CONSTRAINT departments_pkey PRIMARY KEY (id),
    CONSTRAINT departments_company_id_fkey FOREIGN KEY (company_id) REFERENCES company (id)
);


CREATE TABLE IF NOT EXISTS projects
(
    id           serial4      NOT NULL,
    project_name varchar(255) NOT NULL,
    description  varchar(255) NOT NULL,
    start_date   date NULL,
    end_date     date NULL,
    status_id    int4         NOT NULL,
    CONSTRAINT projects_pkey PRIMARY KEY (id),
    CONSTRAINT projects_status_id_fkey FOREIGN KEY (status_id) REFERENCES status (id)
);

CREATE TABLE IF NOT EXISTS address
(
    id           serial4      NOT NULL,
    address_name varchar(255) NOT NULL,
    country_id   int4         NOT NULL,
    city_id      int4         NOT NULL,
    CONSTRAINT address_pkey PRIMARY KEY (id),
    CONSTRAINT address_city_id_fkey FOREIGN KEY (city_id) REFERENCES city (id),
    CONSTRAINT address_country_id_fkey FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TABLE IF NOT EXISTS assignments
(
    id           serial4      NOT NULL,
    project_id   int4         NOT NULL,
    worked_hours int4 NULL,
    isfinished   bool NULL,
    task         varchar(255) NOT NULL,
    CONSTRAINT assignments_pkey PRIMARY KEY (id),
    CONSTRAINT assignments_project_id_fkey FOREIGN KEY (project_id) REFERENCES projects (id)
);


CREATE TABLE IF NOT EXISTS profiles
(
    id            serial4 NOT NULL,
    user_id       int4    NOT NULL,
    address_id    int4    NOT NULL,
    role_id       int4    NOT NULL,
    assignment_id int4    NOT NULL,
    department_id int4    NOT NULL,
    CONSTRAINT profiles_pkey PRIMARY KEY (id),
    CONSTRAINT profiles_address_id_fkey FOREIGN KEY (address_id) REFERENCES address (id),
    CONSTRAINT profiles_assignment_id_fkey FOREIGN KEY (assignment_id) REFERENCES assignments (id),
    CONSTRAINT profiles_department_id_fkey FOREIGN KEY (department_id) REFERENCES departments (id),
    CONSTRAINT profiles_role_id_fkey FOREIGN KEY (role_id) REFERENCES roles (id),
    CONSTRAINT profiles_user_id_fkey FOREIGN KEY (user_id) REFERENCES users (id)
);


CREATE TABLE IF NOT EXISTS user_details
(
    id            serial4 NOT NULL,
    profile_id    int4    NOT NULL,
    date_of_birth date    NOT NULL,
    gender_id     int4    NOT NULL,
    CONSTRAINT user_details_pkey PRIMARY KEY (id),
    CONSTRAINT user_details_gender_id_fkey FOREIGN KEY (gender_id) REFERENCES gender (id),
    CONSTRAINT user_details_profile_id_fkey FOREIGN KEY (profile_id) REFERENCES profiles (id)
);