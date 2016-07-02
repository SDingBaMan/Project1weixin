create table weixinUser(
  wxId character(200),
  userId CHARACTER (200),
 PRIMARY KEY(wxId),
 FOREIGN KEY  (userId) REFERENCES UserMan(umId)
)