package ru.omgtu.ivt.docs.dogs;

public class DogsListResponse {
    public static final String EXAMPLE = """
                        [
                          {
                            "name": "Лаки",
                            "birthDate": "2018-03-12",
                            "color": "Серый",
                            "weight": 57.8,
                            "gender": "MALE",
                            "breedId": 10,
                            "ownerId": 3
                          },
                          {
                            "name": "Шарик",
                            "birthDate": "2016-09-15",
                            "color": "Рыжий",
                            "weight": 48.3,
                            "gender": "MALE",
                            "breedId": 13,
                            "ownerId": 3
                          },
                          {
                            "name": "Дружок",
                            "birthDate": "2022-11-29",
                            "color": "Пестрый",
                            "weight": 49.8,
                            "gender": "FEMALE",
                            "breedId": 14,
                            "ownerId": 3
                          },
                          {
                            "name": "Бим",
                            "birthDate": "2022-09-18",
                            "color": "Серый",
                            "weight": 30.2,
                            "gender": "FEMALE",
                            "breedId": 15,
                            "ownerId": 3
                          },
                          {
                            "name": "Луна",
                            "birthDate": "2025-01-05",
                            "color": "Черный",
                            "weight": 42.4,
                            "gender": "MALE",
                            "breedId": 11,
                            "ownerId": 3
                          },
                          {
                            "name": "Буч",
                            "birthDate": "2015-01-06",
                            "color": "Белый",
                            "weight": 6.7,
                            "gender": "MALE",
                            "breedId": 19,
                            "ownerId": 3
                          },
                          {
                            "name": "Чара",
                            "birthDate": "2017-12-28",
                            "color": "Серый",
                            "weight": 7.5,
                            "gender": "FEMALE",
                            "breedId": 12,
                            "ownerId": 3
                          },
                          {
                            "name": "Буч",
                            "birthDate": "2024-12-06",
                            "color": "Коричневый",
                            "weight": 46.2,
                            "gender": "MALE",
                            "breedId": 20,
                            "ownerId": 3
                          },
                          {
                            "name": "Лайма",
                            "birthDate": "2021-11-03",
                            "color": "Пестрый",
                            "weight": 53.7,
                            "gender": "FEMALE",
                            "breedId": 17,
                            "ownerId": 3
                          },
                          {
                            "name": "Дружок",
                            "birthDate": "2021-11-19",
                            "color": "Черный",
                            "weight": 37.5,
                            "gender": "MALE",
                            "breedId": 4,
                            "ownerId": 3
                          },
                          {
                            "name": "Шарик",
                            "birthDate": "2021-05-18",
                            "color": "Рыжий",
                            "weight": 45.6,
                            "gender": "FEMALE",
                            "breedId": 12,
                            "ownerId": 3
                          },
                          {
                            "name": "Лайма",
                            "birthDate": "2015-08-15",
                            "color": "Коричневый",
                            "weight": 45.9,
                            "gender": "MALE",
                            "breedId": 9,
                            "ownerId": 3
                          },
                          {
                            "name": "Бим",
                            "birthDate": "2023-06-17",
                            "color": "Пестрый",
                            "weight": 21.0,
                            "gender": "MALE",
                            "breedId": 14,
                            "ownerId": 3
                          },
                          {
                            "name": "Тайсон",
                            "birthDate": "2015-02-11",
                            "color": "Черный",
                            "weight": 50.6,
                            "gender": "FEMALE",
                            "breedId": 3,
                            "ownerId": 3
                          },
                          {
                            "name": "Шарик",
                            "birthDate": "2022-02-18",
                            "color": "Рыжий",
                            "weight": 6.3,
                            "gender": "MALE",
                            "breedId": 13,
                            "ownerId": 3
                          },
                          {
                            "name": "Лаки",
                            "birthDate": "2019-01-12",
                            "color": "Белый",
                            "weight": 52.7,
                            "gender": "MALE",
                            "breedId": 16,
                            "ownerId": 3
                          },
                          {
                            "name": "Бим",
                            "birthDate": "2017-11-29",
                            "color": "Черный",
                            "weight": 15.0,
                            "gender": "FEMALE",
                            "breedId": 7,
                            "ownerId": 3
                          },
                          {
                            "name": "Чара",
                            "birthDate": "2023-10-01",
                            "color": "Пестрый",
                            "weight": 51.3,
                            "gender": "MALE",
                            "breedId": 16,
                            "ownerId": 3
                          },
                          {
                            "name": "Снежок",
                            "birthDate": "2016-01-31",
                            "color": "Коричневый",
                            "weight": 22.8,
                            "gender": "FEMALE",
                            "breedId": 5,
                            "ownerId": 3
                          },
                          {
                            "name": "Чара",
                            "birthDate": "2022-04-09",
                            "color": "Палевый",
                            "weight": 37.0,
                            "gender": "MALE",
                            "breedId": 18,
                            "ownerId": 3
                          },
                          {
                            "name": "Лаки",
                            "birthDate": "2021-05-19",
                            "color": "Черный",
                            "weight": 48.0,
                            "gender": "MALE",
                            "breedId": 1,
                            "ownerId": 3
                          },
                          {
                            "name": "Бим",
                            "birthDate": "2024-09-10",
                            "color": "Палевый",
                            "weight": 55.8,
                            "gender": "FEMALE",
                            "breedId": 10,
                            "ownerId": 3
                          },
                          {
                            "name": "Гром",
                            "birthDate": "2017-12-17",
                            "color": "Пестрый",
                            "weight": 50.8,
                            "gender": "FEMALE",
                            "breedId": 9,
                            "ownerId": 3
                          },
                          {
                            "name": "Гром",
                            "birthDate": "2014-07-27",
                            "color": "Пестрый",
                            "weight": 43.6,
                            "gender": "FEMALE",
                            "breedId": 15,
                            "ownerId": 3
                          },
                          {
                            "name": "Buddy",
                            "birthDate": "2016-11-16",
                            "color": "Черный",
                            "weight": 37.0,
                            "gender": "MALE",
                            "breedId": 6,
                            "ownerId": 3
                          },
                          {
                            "name": "Тоша",
                            "birthDate": "2014-10-30",
                            "color": "Рыжий",
                            "weight": 47.6,
                            "gender": "FEMALE",
                            "breedId": 19,
                            "ownerId": 3
                          },
                          {
                            "name": "Шарик",
                            "birthDate": "2016-11-16",
                            "color": "Белый",
                            "weight": 19.5,
                            "gender": "FEMALE",
                            "breedId": 2,
                            "ownerId": 3
                          },
                          {
                            "name": "Буся",
                            "birthDate": "2021-09-20",
                            "color": "Белый",
                            "weight": 8.0,
                            "gender": "MALE",
                            "breedId": 18,
                            "ownerId": 3
                          },
                          {
                            "name": "Атос",
                            "birthDate": "2016-11-16",
                            "color": "Черный",
                            "weight": 37.0,
                            "gender": "MALE",
                            "breedId": 20,
                            "ownerId": 3
                          },
                          {
                            "name": "Грей",
                            "birthDate": "2019-11-29",
                            "color": "Черный",
                            "weight": 58.8,
                            "gender": "MALE",
                            "breedId": 11,
                            "ownerId": 3
                          },
                          {
                            "name": "Марта",
                            "birthDate": "2017-08-09",
                            "color": "Рыжий",
                            "weight": 51.9,
                            "gender": "FEMALE",
                            "breedId": 8,
                            "ownerId": 3
                          },
                          {
                            "name": "Чара",
                            "birthDate": "2023-04-27",
                            "color": "Коричневый",
                            "weight": 52.4,
                            "gender": "FEMALE",
                            "breedId": 17,
                            "ownerId": 3
                          }
                        ]
            """;
}
