CREATE TABLE municipality (
    id         	        INT NOT NULL PRIMARY KEY,
    name                VARCHAR(64)
);

INSERT into municipality (id,name) VALUES
("0","Ikke angivet"),("101","København"),("147","Frederiksberg"),("151","Ballerup"),("153","Brøndby"),("155","Dragør"),
("157","Gentofte"),("159","Gladsaxe"),("161","Glostrup"),("163","Herlev"),("165","Albertslund"),("167","Hvidovre"),
("169","Høje-Taastrup"),("173","Lyngby-Taarbæk"),("175","Rødovre"),("183","Ishøj"),("185","Tårnby"),("187","Vallensbæk"),
("190","Furesø"),("201","Allerød"),("210","Fredensborg"),("217","Helsingør"),("219","Hillerød"),("223","Hørsholm"),
("230","Rudersdal"),("240","Egedal"),("250","Frederikssund"),("253","Greve"),("259","Køge"),("260","Halsnæs"),("265","Roskilde"),
("269","Solrød"),("270","Gribskov"),("306","Odsherred"),("316","Holbæk"),("320","Faxe"),("326","Kalundborg"),("329","Ringsted"),
("330","Slagelse"),("336","Stevns"),("340","Sorø"),("350","Lejre"),("360","Lolland"),("370","Næstved"),("376","Guldborgsund"),("390","Vordingborg"),
("400","Bornholm"),("410","Middelfart"),("411","Christiansø"),("420","Assens"),("430","Faaborg-Midtfyn"),("440","Kerteminde"),
("450","Nyborg"),("461","Odense"),("479","Svendborg"),("480","Nordfyns"),("482","Langeland"),("492","Ærø"),
("510","Haderslev"),("530","Billund"),("540","Sønderborg"),("550","Tønder"),("561","Esbjerg"),("563","Fanø"),("573","Varde"),
("575","Vejen"),("580","Aabenraa"),("607","Fredericia"),("615","Horsens"),("621","Kolding"),("630","Vejle"),
("657","Herning"),("661","Holstebro"),("665","Lemvig"),("671","Struer"),("706","Syddjurs"),("707","Norddjurs"),
("710","Favrskov"),("727","Odder"),("730","Randers"),("740","Silkeborg"),("741","Samsø"),("746","Skanderborg"),
("751","Aarhus"),("756","Ikast-Brande"),("760","Ringkøbing-Skjern"),("766","Hedensted"),("773","Morsø"),("779","Skive"),
("787","Thisted"),("791","Viborg"),("810","Brønderslev"),("813","Frederikshavn"),("820","Vesthimmerlands"),("825","Læsø"),
("840","Rebild"),("846","Mariagerfjord"),("849","Jammerbugt"),("851","Aalborg"),("860","Hjørring");

ALTER TABLE consent_template ADD COLUMN municipality_id INT;

update consent_template set municipality_id = ${MUNICIPALITY};

ALTER TABLE consent ADD COLUMN municipality_id INT;

update consent set municipality_id = ${MUNICIPALITY};