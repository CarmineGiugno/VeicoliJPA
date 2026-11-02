
    set client_min_messages = WARNING;

    alter table if exists veicolo 
       drop constraint if exists FK1ffq24yvhb1147soqdmhcrr75;

    drop table if exists categoria cascade;

    drop table if exists veicolo cascade;
