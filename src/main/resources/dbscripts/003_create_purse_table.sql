CREATE TABLE purse
(
  id    INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  ownerId     INT                            NOT NULL,
  FOREIGN KEY (ownerId) REFERENCES user (id),
  currencyId INT                            NOT NULL,
  FOREIGN KEY (currencyId) REFERENCES currency (id),
  name       VARCHAR(45)                    NOT NULL,
  amount     INT                            NOT NULL


);