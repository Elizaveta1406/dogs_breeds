const API = "http://localhost:8080/api";

function getToken() {
  return localStorage.getItem("token");
}

function authHeaders() {
  return {
    "Authorization": "Bearer " + getToken(),
    "Content-Type": "application/json"
  };
}

function login() {
  fetch(`${API}/auth/login`, {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify({
      username: document.getElementById("username").value,
      password: document.getElementById("password").value
    })
  })
  .then(res => {
    if(res.status >= 200 && res.status < 300) {
      return res.json();
    } else {
      let error = new Error("Ошибка авторизации");
      throw error;
    }
  })
  .then(data => {
    localStorage.setItem("token", data.accessToken);
    alert("Вход выполнен");
    loadDogs();
    loadBreeds();
    loadBreedOptions();
    updateUI();
  }).catch(error => {
    alert(error.message);
  });
}
function logout() {
  localStorage.removeItem("token");
  document.location.reload();
}

function register() {
  fetch(`${API}/auth/register`, {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify({
      username: document.getElementById("username").value,
      password: document.getElementById("password").value
    })
  })
  .then(res => res.json())
  .then(data => {
    localStorage.setItem("token", data.accessToken);
    alert("Регистрация выполнена");
    loadDogs();
    loadBreeds();
  });
}

function addDog() {
  const dog = {
    name: document.getElementById("dogName").value,
    birthDate: document.getElementById("dogBirthDate").value,
    color: document.getElementById("dogColor").value,
    weight: parseFloat(document.getElementById("dogWeight").value),
    gender: document.getElementById("dogGender").value,
    breedId: document.getElementById("dogBreedId").value
  };

  fetch(`${API}/dogs`, {
    method: "POST",
    headers: authHeaders(),
    body: JSON.stringify(dog)
  }).then((res) => {
    if(res.status >= 200 && res.status < 300) {
      alert("Собака добавлена");
      loadDogs();
    } else {
      alert("Ошибка прав доступа");
    }
  });
}

function deleteDog(id) {
  fetch(`${API}/dogs/${id}`, {
    method: "DELETE",
    headers: authHeaders()
  }).then((res)=> {
    if(res.status >= 200 && res.status < 300) {
      alert("Собака удалена")
      loadDogs();
    }else{
      alert("Ошибка прав доступа");
    }
  });
}

function loadDogs() {
  fetch(`${API}/dogs`, { headers: authHeaders() })
    .then(res => res.json())
    .then(dogs => {
      const list = document.getElementById("dogList");
      list.innerHTML = "";
      dogs.forEach(dog => {
        const li = document.createElement("li");
        li.className = "list-group-item d-flex justify-content-between align-items-center";
        li.innerHTML = `
          ${dog.name} (${dog.weight} кг)
          <button class="btn btn-sm btn-danger" onclick="deleteDog(${dog.id})">Удалить</button>
        `;
        list.appendChild(li);
      });
    });
}

function addBreed() {
  const breed = {
    name: document.getElementById("breedName").value,
    originCountry: document.getElementById("breedOrigin").value,
    description: document.getElementById("breedDesc").value,
    avgLifespan: parseInt(document.getElementById("breedLifespan").value),
    size: document.getElementById("breedSize").value,
    temperament: document.getElementById("breedTemperament").value,
    imageUrl: document.getElementById("breedImage").value
  };

  fetch(`${API}/breeds`, {
    method: "POST",
    headers: authHeaders(),
    body: JSON.stringify(breed)
  }).then((res) => {
    if(res.status >= 200 && res.status < 300) {
      alert("Порода добавлена");
      loadBreeds();
      loadBreedOptions();
    } else {
      alert("Ошибка прав доступа")
    }
  });
}

function deleteBreed(id) {
  fetch(`${API}/breeds/${id}`, {
    method: "DELETE",
    headers: authHeaders()
  }).then((res) => {
    if(res.status >= 200 && res.status < 300) {
      alert("Порода удалена");
      loadBreeds();
      loadBreedOptions();
    } else {
      alert("Ошибка прав доступа")
    }
  });
}

function loadBreeds() {
  fetch(`${API}/breeds`, { headers: authHeaders() })
    .then(res => res.json())
    .then(breeds => {
      const list = document.getElementById("breedList");
      list.innerHTML = "";
      breeds.forEach(breed => {
        const li = document.createElement("li");
        li.className = "list-group-item d-flex justify-content-between align-items-center";
        li.innerHTML = `
          ${breed.name} (${breed.size})
          <button class="btn btn-sm btn-danger" onclick="deleteBreed(${breed.id})">Удалить</button>
        `;
        list.appendChild(li);
      });
    });
}

function loadBreedOptions() {
  console.log("loadBreedOptions");
  fetch(`${API}/breeds`, { headers: authHeaders() })
    .then(res => res.json())
    .then(breeds => {
      const select = document.getElementById("dogBreedId");
      select.innerHTML = "";
      breeds.forEach(b => {
        const opt = document.createElement("option");
        opt.value = b.id;
        opt.textContent = `${b.name} (${b.size})`;
        select.appendChild(opt);
      });
    });
}
function updateUI() {
  var dogsWrapper = document.getElementById("dogsWrapper"),
      breedsWrapper = document.getElementById("breedsWrapper");

  if (getToken()) {
    dogsWrapper.classList.remove("d-none");
    breedsWrapper.classList.remove("d-none");
    dogsWrapper.classList.add("d-block");
    breedsWrapper.classList.add("d-block");
  } else {
    dogsWrapper.classList.add("d-none");
    breedsWrapper.classList.add("d-none");
    dogsWrapper.classList.remove("d-block");
    breedsWrapper.classList.remove("d-block");
  }
}
// проверка доступа
if (getToken()) {
  updateUI();
  loadDogs();
  loadBreeds();
  loadBreedOptions();
}

