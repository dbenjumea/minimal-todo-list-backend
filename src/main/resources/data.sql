-- H2 creates the table with each column in alphabetic order so the inserts have to be exactly in that order and not in the class order
-- For user is ID, PASSWORD, USERNAME
insert into user
values(1,'pwd123', 'test');

-- For task is ID, DAYS, DESCRIPTION, TITLE, USER
insert into task
values(1,2, 'Develop Back-end', '2018-01-01', 'Task 1', 1);
insert into task
values(2,3, 'Develop Front-end', '2018-01-02', 'Task 2', 1);
insert into task
values(3,1, 'Create database', '2018-01-03', 'Task 3', 1);