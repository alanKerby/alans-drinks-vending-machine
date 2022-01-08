drop table if exists drink cascade;
CREATE TABLE `drink` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `coffee_beans_grams` int NOT NULL,
                         `frothed_milk` bit(1) NOT NULL,
                         `hot_milk` bit(1) NOT NULL,
                         `hot_waterml` int NOT NULL,
                         `ice_water_ml` int NOT NULL,
                         `milkml` int NOT NULL,
                         `name` varchar(255) NOT NULL,
                         `sugar_syrup_ml` int NOT NULL,
                         PRIMARY KEY (`id`)
)
