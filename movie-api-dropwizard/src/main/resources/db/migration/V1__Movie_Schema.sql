create table movie (
    id bigint not null auto_increment primary key,
    name varchar(128) not null,
    rated varchar(32),
    lang varchar(64),
    actors varchar(1024),
    crew varchar(1024),
    genres varchar(1024),
    plot varchar(1024),
    release_date timestamp,
    viewer_rating double
);

insert into movie (name, rated, lang, actors, crew, genres, plot, release_date, viewer_rating) values ('Dr. No', 'A', 'English', 'Sean Connery', 'Terence Young', 'Spy', 'In the film, James Bond is sent to Jamaica to investigate the disappearance of a fellow British agent.', parsedatetime('05-11-1962', 'dd-MM-yyyy'), 6.8);
insert into movie (name, rated, lang, actors, crew, genres, plot, release_date, viewer_rating) values ('The spy who loved me', 'A', 'English', 'Roger Moore', 'Lewis Gilbert', 'Spy', 'The storyline involves a reclusive megalomaniac named Karl Stromberg, who plans to destroy the world and create a new civilisation under the sea.', parsedatetime('07-07-1977', 'dd-MM-yyyy'), 6.5);
insert into movie (name, rated, lang, actors, crew, genres, plot, release_date, viewer_rating) values ('Golden Eye', 'A', 'English', 'Pierce Brosnan', 'Martin Campbell', 'Spy', 'In the film, Bond fights to prevent an ex-MI6 agent, gone rogue, from using a satellite weapon against London to cause a global financial meltdown.', parsedatetime('13-11-1995', 'dd-MM-yyyy'), 7.1);
insert into movie (name, rated, lang, actors, crew, genres, plot, release_date, viewer_rating) values ('Casino Royale', 'A', 'English', 'Daniel Craig', 'Martin Campbell', 'Spy', 'The plot has Bond on an assignment to bankrupt terrorist financier Le Chiffre in a high-stakes poker game at the Casino Royale in Montenegro', parsedatetime('14-11-2006', 'dd-MM-yyyy'), 6.3);