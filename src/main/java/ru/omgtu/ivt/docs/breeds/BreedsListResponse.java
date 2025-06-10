package ru.omgtu.ivt.docs.breeds;

public class BreedsListResponse {
    public static final String EXAMPLE = """
            [
                           {
                             "name": "Лабрадор ретривер",
                             "originCountry": "Канада",
                             "description": "Дружелюбная и активная порода",
                             "avgLifespan": 12,
                             "size": "LARGE",
                             "temperament": "Дружелюбный, активный, умный",
                             "imageUrl": "https://example.com/images/labrador.jpg"
                           },
                           {
                             "name": "Чихуахуа",
                             "originCountry": "Мексика",
                             "description": "Крошечная, но смелая собака-компаньон",
                             "avgLifespan": 14,
                             "size": "TOY",
                             "temperament": "Смелый, независимый, живой",
                             "imageUrl": "https://example.com/images/chihuahua.jpg"
                           },
                           {
                             "name": "Немецкая овчарка",
                             "originCountry": "Германия",
                             "description": "Умная, преданная, хорошо обучаемая",
                             "avgLifespan": 11,
                             "size": "LARGE",
                             "temperament": "Умный, преданный, защитный",
                             "imageUrl": "https://example.com/images/german_shepherd.jpg"
                           },
                           {
                             "name": "Бигль",
                             "originCountry": "Англия",
                             "description": "Любопытная и добрая порода",
                             "avgLifespan": 13,
                             "size": "MEDIUM",
                             "temperament": "Дружелюбный, любопытный, ласковый",
                             "imageUrl": "https://example.com/images/beagle.jpg"
                           },
                           {
                             "name": "Дог",
                             "originCountry": "Германия",
                             "description": "Добродушный гигант с мягким характером",
                             "avgLifespan": 8,
                             "size": "GIANT",
                             "temperament": "Спокойный, любящий, уравновешенный",
                             "imageUrl": "https://example.com/images/great_dane.jpg"
                           },
                           {
                             "name": "Йоркширский терьер",
                             "originCountry": "Англия",
                             "description": "Энергичная и элегантная порода",
                             "avgLifespan": 15,
                             "size": "TOY",
                             "temperament": "Бдительный, решительный, ласковый",
                             "imageUrl": "https://example.com/images/yorkshire_terrier.jpg"
                           },
                           {
                             "name": "Шпиц",
                             "originCountry": "Германия",
                             "description": "Пушистая, умная и преданная собака",
                             "avgLifespan": 13,
                             "size": "SMALL",
                             "temperament": "Бдительный, энергичный, любящий",
                             "imageUrl": "https://example.com/images/spitz.jpg"
                           },
                           {
                             "name": "Боксер",
                             "originCountry": "Германия",
                             "description": "Легко обучаемая порода с крепким телосложением",
                             "avgLifespan": 10,
                             "size": "MEDIUM",
                             "temperament": "Игривый, преданный, уверенный",
                             "imageUrl": "https://example.com/images/boxer.jpg"
                           },
                           {
                             "name": "Сибирский хаски",
                             "originCountry": "Россия",
                             "description": "Выносливая, преданная ездовая собака",
                             "avgLifespan": 10,
                             "size": "MEDIUM",
                             "temperament": "Дружелюбный, энергичный, независимый",
                             "imageUrl": "https://example.com/images/siberian_husky.jpg"
                           },
                           {
                             "name": "Пудель",
                             "originCountry": "Франция",
                             "description": "Нежная и интеллигентная собака-компаньон",
                             "avgLifespan": 12,
                             "size": "MEDIUM",
                             "temperament": "Интеллигентный, активный, послушный",
                             "imageUrl": "https://example.com/images/poodle.jpg"
                           },
                           {
                             "name": "Ротвейлер",
                             "originCountry": "Германия",
                             "description": "Сильная и отважная порода",
                             "avgLifespan": 11,
                             "size": "LARGE",
                             "temperament": "Защитный, уверенный, преданный",
                             "imageUrl": "https://example.com/images/rottweiler.jpg"
                           },
                           {
                             "name": "Золотистый ретривер",
                             "originCountry": "Шотландия",
                             "description": "Преданная и терпеливая, хороша для семьи",
                             "avgLifespan": 14,
                             "size": "LARGE",
                             "temperament": "Дружелюбный, терпеливый, мягкий",
                             "imageUrl": "https://example.com/images/golden_retriever.jpg"
                           },
                           {
                             "name": "Доберман",
                             "originCountry": "Германия",
                             "description": "Храбрая и энергичная порода",
                             "avgLifespan": 9,
                             "size": "LARGE",
                             "temperament": "Бдительный, энергичный, решительный",
                             "imageUrl": "https://example.com/images/doberman.jpg"
                           },
                           {
                             "name": "Джек-рассел-терьер",
                             "originCountry": "Англия",
                             "description": "Компактная и живой охотник",
                             "avgLifespan": 15,
                             "size": "SMALL",
                             "temperament": "Игривый, живой, смелый",
                             "imageUrl": "https://example.com/images/jack_russell.jpg"
                           },
                           {
                             "name": "Акита",
                             "originCountry": "Япония",
                             "description": "Красивая, спокойная и независимая",
                             "avgLifespan": 12,
                             "size": "LARGE",
                             "temperament": "Достойный, независимый, преданный",
                             "imageUrl": "https://example.com/images/akita.jpg"
                           },
                           {
                             "name": "Папильон",
                             "originCountry": "Франция",
                             "description": "Игривый и сообразительный, подходит для квартир",
                             "avgLifespan": 13,
                             "size": "TOY",
                             "temperament": "Умный, живой, ласковый",
                             "imageUrl": "https://example.com/images/papillon.jpg"
                           },
                           {
                             "name": "Ши-тцу",
                             "originCountry": "Китай",
                             "description": "Компактная сторожевая собака",
                             "avgLifespan": 13,
                             "size": "TOY",
                             "temperament": "Спокойный, ласковый, упрямый",
                             "imageUrl": "https://example.com/images/shih_tzu.jpg"
                           },
                           {
                             "name": "Кокер-спаниель",
                             "originCountry": "Англия",
                             "description": "Длинношерстная охотничья собака",
                             "avgLifespan": 14,
                             "size": "MEDIUM",
                             "temperament": "Энергичный, веселый, ласковый",
                             "imageUrl": "https://example.com/images/cocker_spaniel.jpg"
                           },
                           {
                             "name": "Аляскинский маламут",
                             "originCountry": "США",
                             "description": "Устойчивый к холоду, хороший охранник",
                             "avgLifespan": 11,
                             "size": "LARGE",
                             "temperament": "Независимый, дружелюбный, упрямый",
                             "imageUrl": "https://example.com/images/alaskan_malamute.jpg"
                           },
                           {
                             "name": "Американский питбуль",
                             "originCountry": "США",
                             "description": "Сильная и умная порода с короткой шерстью",
                             "avgLifespan": 13,
                             "size": "MEDIUM",
                             "temperament": "Энергичный, умный, уверенный",
                             "imageUrl": "https://example.com/images/pitbull.jpg"
                           }
                         ]
            """;
}
