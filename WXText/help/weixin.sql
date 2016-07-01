create table weixinUser(
  wxId character(200),
  userId CHARACTER (200),
 PRIMARY KEY(wxId),
 FOREIGN KEY  (wxId) REFERENCES UserMan(umId)
)