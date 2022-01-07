  CREATE TABLE IF NOT EXISTS  inspector(
    id serial,
    name VARCHAR(45) NOT NULL,
    lastname VARCHAR(45) NULL,
    phone VARCHAR (45) NULL,

    PRIMARY KEY (id)
    );

    CREATE TABLE IF NOT EXISTS  fouls(
        id serial,
        description VARCHAR(45) NOT NULL,
        data VARCHAR(45) Not NULL,
        inspector_id int,

        PRIMARY KEY (id),
        FOREIGN KEY (inspector_id) REFERENCES inspector (id)


        );

        CREATE TABLE IF NOT EXISTS  student(
          id serial,
          name VARCHAR(45) NOT NULL,
          lastname VARCHAR(45) NULL,
          fouls_id int,
          PRIMARY KEY (id),
          FOREIGN KEY (fouls_id) REFERENCES fouls(id)

        );