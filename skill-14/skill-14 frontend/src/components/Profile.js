import { useEffect, useState } from "react";
import { api, getNetworkErrorMessage } from "../api";

function Profile() {
  const [data, setData] = useState({});
  const username = localStorage.getItem("user");

  useEffect(() => {
    if (!username) {
      return;
    }

    api
      .get(`/user/${username}`)
      .then((res) => setData(res.data))
      .catch((error) => {
        alert(getNetworkErrorMessage(error));
      });
  }, [username]);

  return (
    <div>
      <h2>Profile</h2>
      <p>Username: {data.username}</p>
    </div>
  );
}

export default Profile;