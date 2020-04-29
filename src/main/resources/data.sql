INSERT INTO CUSTOMER  (id, name, type, date_created ) VALUES (1, 'Standard Old User', 'STANDARD', NOW()-INTERVAL 3 YEAR);
INSERT INTO CUSTOMER  (id, name, type, date_created ) VALUES (2, 'Standard New User', 'STANDARD', NOW());
INSERT INTO CUSTOMER  (id, name, type, date_created ) VALUES (3, 'Employee User', 'EMPLOYEE', NOW());
INSERT INTO CUSTOMER  (id, name, type, date_created ) VALUES (4, 'Affiliate User', 'AFFILIATE', NOW());


INSERT INTO DISCOUNT  (id, key, ratio, type ) VALUES ( 1, 'FLAT', 0.0, 'CUSTOM');
INSERT INTO DISCOUNT  (id, key, ratio, type ) VALUES ( 2, 'EMPLOYEE', 0.3, 'PERCENTAGE');
INSERT INTO DISCOUNT  (id, key, ratio, type ) VALUES ( 3, 'AFFILIATE', 0.1, 'PERCENTAGE');
INSERT INTO DISCOUNT  (id, key, ratio, type ) VALUES ( 4, 'LOYALTY', 0.05, 'PERCENTAGE');
