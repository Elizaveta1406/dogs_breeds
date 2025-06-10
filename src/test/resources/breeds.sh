#!/bin/bash

API_URL="http://localhost:8080/api/breeds"
TOKEN="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc0OTI3NjUyNSwiZXhwIjoxNzQ5MzYyOTI1fQ.NbH9N2kAy0FM1Mh11xF3ksCxvyvKssQO0RNmb9wU4oA"

declare -a BREEDS=(
'{
  "name": "Лабрадор ретривер",
  "originCountry": "Канада",
  "description": "Дружелюбная и активная порода",
  "avgLifespan": 12,
  "size": "LARGE"
}'
'{
  "name": "Чихуахуа",
  "originCountry": "Мексика",
  "description": "Крошечная, но смелая собака-компаньон",
  "avgLifespan": 14,
  "size": "TOY"
}'
'{
  "name": "Немецкая овчарка",
  "originCountry": "Германия",
  "description": "Умная, верная и легкообучаемая",
  "avgLifespan": 11,
  "size": "LARGE"
}'
'{
  "name": "Бигль",
  "originCountry": "Англия",
  "description": "Любопытная и добрая порода",
  "avgLifespan": 13,
  "size": "MEDIUM"
}'
'{
  "name": "Дог",
  "originCountry": "Германия",
  "description": "Добродушный гигант с мягким характером",
  "avgLifespan": 8,
  "size": "GIANT"
}'
'{
  "name": "Йоркширский терьер",
  "originCountry": "Англия",
  "description": "Маленькая, энергичная и элегантная порода",
  "avgLifespan": 15,
  "size": "TOY"
}'
'{
  "name": "Шпиц",
  "originCountry": "Германия",
  "description": "Пушистая, умная и бдительная собака",
  "avgLifespan": 13,
  "size": "SMALL"
}'
)

for BREED in "${BREEDS[@]}"
do
  echo "➡ Отправка: $BREED"
  curl -s -X POST "$API_URL" \
    -H "Authorization: Bearer $TOKEN" \
    -H "Content-Type: application/json; charset=UTF-8" \
    -d "$BREED"
  echo -e "\n✔️ ---"
done