CREATE TABLE exchange
(
  id    INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  sourceCurrencyId     INT                            NOT NULL,
  FOREIGN KEY (sourceCurrencyId) REFERENCES currency (id),
  targetCurrencyId INT                            NOT NULL,
  FOREIGN KEY (targetCurrencyId) REFERENCES currency (id),
  exchangeRate       FLOAT                   NOT NULL,

);