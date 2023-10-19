const BASE_URL = "http://localhost:8080/api/v1";

export const getAllStudentScores = async () => {
  const response = await fetch(`${BASE_URL}`);
  const data = await response.json();
  console.log(data)
  return data;
};

export const addNewSATScore = async (scoreData) => {
  const response = await fetch(`${BASE_URL}`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(scoreData),
  });
  const data = await response.json();
  return data;
};

export const getStudentRank = async (studentName) => {
  const response = await fetch(`${BASE_URL}/rank`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ studentName }),
  });
  const data = await response.json();
  return data;
};

export const updateScoreByName = async (studentName, updatedData) => {
  const response = await fetch(`${BASE_URL}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ studentName, ...updatedData }),
  });
  const data = await response.json();
  return data;
};

export const deleteScoreByName = async (studentName) => {
  const response = await fetch(`${BASE_URL}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ studentName }),
  });
  const data = await response.json();
  return data;
};
