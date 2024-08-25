BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- data collected February 10, 2021
-- state name, abbrev, capital, population (2019 estimate), area (sq km, 2018 data) - https://en.wikipedia.org/wiki/List_of_states_and_territories_of_the_United_States
-- state sales tax (base) - https://en.wikipedia.org/wiki/Sales_taxes_in_the_United_States
-- state nickname (first official nickname only, NULL if no official nickname) - https://en.wikipedia.org/wiki/List_of_U.S._state_and_territory_nicknames
-- census region - https://en.wikipedia.org/wiki/List_of_regions_of_the_United_States#Census_Bureau-designated_regions_and_divisions
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('AL', 'Alabama', 4903185, 135767, 4, 'Heart of Dixie', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('AK', 'Alaska', 731545, 1723337, 0, 'The Last Frontier', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('AS', 'American Samoa', 57400, 1505, 0, 'Motu o Fiafiaga', NULL);
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('AZ', 'Arizona', 7278717, 295234, 5.6, 'Grand Canyon State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('AR', 'Arkansas', 3017804, 137732, 6.5, 'The Natural State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('CA', 'California', 39512223, 423967, 7.25, 'The Golden State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('CO', 'Colorado', 5758736, 269601, 2.9, 'Centennial State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('CT', 'Connecticut', 3565278, 14357, 6.35, 'Constitution State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('DE', 'Delaware', 973764, 6446, 0, 'The First State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('DC', 'District of Columbia', 705749, 176, 5.75, NULL, 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('FL', 'Florida', 21477737, 170312, 6, 'Sunshine State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('GA', 'Georgia', 10617423, 153910, 4, 'Peach State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('GU', 'Guam', 161700, 1478, 4, 'Tano y Chamorro', NULL);
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('HI', 'Hawaii', 1415872, 28313, 4.166, 'Aloha State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('ID', 'Idaho', 1787065, 216443, 6, 'Gem State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('IL', 'Illinois', 12671821, 149995, 6.25, 'Prairie State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('IN', 'Indiana', 6732219, 94326, 7, 'Hoosier State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('IA', 'Iowa', 3155070, 145746, 6, 'Hawkeye State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('KS', 'Kansas', 2913314, 213100, 6.5, 'Sunflower State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('KY', 'Kentucky', 4467673, 104656, 6, 'Bluegrass State ', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('LA', 'Louisiana', 4648794, 135659, 4.45, 'Pelican State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('ME', 'Maine', 1344212, 91633, 5.5, 'Vacationland', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MD', 'Maryland', 6045680, 32131, 6, 'Free State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MA', 'Massachusetts', 6892503, 27336, 6.25, 'The Bay State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MI', 'Michigan', 9986857, 250487, 6, 'The Great Lakes State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MN', 'Minnesota', 5639632, 225163, 6.875, 'Land of 10,000 Lakes', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MS', 'Mississippi', 2976149, 125438, 7, 'Magnolia State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MO', 'Missouri', 6137428, 180540, 4.225, 'Show-Me State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MT', 'Montana', 1068778, 380831, 0, 'Treasure State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NE', 'Nebraska', 1934408, 200330, 5.5, 'Cornhusker State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NV', 'Nevada', 3080156, 286380, 6.85, 'Silver State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NH', 'New Hampshire', 1359711, 24214, 0, 'Granite State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NJ', 'New Jersey', 8882190, 22591, 6.625, 'Garden State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NM', 'New Mexico', 2096829, 314917, 5.125, 'Land of Enchantment', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NY', 'New York', 19453561, 141297, 4, 'Empire State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('NC', 'North Carolina', 10488084, 139391, 4.75, 'Tar Heel State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('ND', 'North Dakota', 762062, 183108, 5, 'Peace Garden State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('MP', 'Northern Mariana Islands', 52300, 5117, 0, NULL, NULL);
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('OH', 'Ohio', 11689100, 116098, 5.75, 'Buckeye State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('OK', 'Oklahoma', 3956971, 181037, 4.5, 'Sooner State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('OR', 'Oregon', 4217737, 254799, 0, 'Beaver State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('PA', 'Pennsylvania', 12801989, 119280, 6, 'Keystone State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('PR', 'Puerto Rico', 3193694, 13791, 10.5, 'Isla del Encanto', NULL);
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('RI', 'Rhode Island', 1059361, 4001, 7, 'Ocean State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('SC', 'South Carolina', 5148714, 82933, 6, 'Palmetto State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('SD', 'South Dakota', 884659, 199729, 4, 'The Mount Rushmore State', 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('TN', 'Tennessee', 6829174, 109153, 7, 'Volunteer State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('TX', 'Texas', 28995881, 695662, 6.25, 'Lone Star State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('VI', 'U.S. Virgin Islands', 103700, 1898, 5, NULL, NULL);
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('UT', 'Utah', 3205958, 219882, 5.95, 'Beehive State', 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('VT', 'Vermont', 623989, 24906, 6, 'Green Mountain State', 'Northeast');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('VA', 'Virginia', 8535519, 110787, 5.3, 'The Old Dominion', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('WA', 'Washington', 7614893, 184661, 6.5, NULL, 'West');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('WV', 'West Virginia', 1792147, 62756, 6, 'Mountain State', 'South');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('WI', 'Wisconsin', 5822434, 169635, 5, NULL, 'Midwest');
INSERT INTO state (state_abbreviation, state_name, population, area, sales_tax, state_nickname, census_region) VALUES ('WY', 'Wyoming', 578759, 253335, 4, 'Equality State', 'West');

COMMIT TRANSACTION;
