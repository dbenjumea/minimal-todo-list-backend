-- H2 creates the table with each column in alphabetic order so the inserts have to be exactly in that order and not in the class order
-- For user is ID, PASSWORD, USERNAME
insert into user
values(1,'pwd123', 'test');

-- For task is ID, DAYS, DESCRIPTION, TITLE, USER
insert into task
values(1,2, 'First test task', 'Test Task 1', 1);