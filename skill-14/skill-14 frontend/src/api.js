import axios from "axios";

export const API_BASE_URL = process.env.REACT_APP_API_URL || "http://localhost:8080";

export const api = axios.create({
  baseURL: API_BASE_URL,
  timeout: 10000,
});

export const getNetworkErrorMessage = (error) => {
  if (error?.response?.data?.message) {
    return error.response.data.message;
  }

  if (error?.code === "ERR_NETWORK") {
    return "Cannot reach API server. Ensure backend is running on " + API_BASE_URL;
  }

  return "Request failed. Please try again.";
};
