import axios from "axios";

async function getUserData() {
    const token = localStorage.getItem('jwtToken');
    const t = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGlib3VAbWFpbC5jb20iLCJpYXQiOjE3MDA4NDEyNTcsImV4cCI6MTcwMDg0MjY5N30.AusExtifE2gd5WDZvPKTQNK5cI80Fb1kgCRFzGf0Cqc'
    return axios
        .get("http://localhost:9800/normal-user/account-data", {
            withCredentials: true,
            
            headers: {
                
                Authorization: `Bearer ${t}`,
            },
        })

    // return fetch("http://localhost:9800/normal-user/account-data", {
    //     withCredentials: "true",
    //     headers: {

    //         'Authorization': 'Bearer ' + token
    //     },


    // })
}




function getUserMaxes() {
    return fetch("http://localhost:9800/normal-user/user-maxes")
}



async function updateUsersData(data) {
    return await fetch("http://localhost:9800/normal-user/update-data", {
        method: 'Post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, body: JSON.stringify(data)
    }
    )
}


async function addUserMaxes(data) {
    return await fetch("http://localhost:9800/normal-user/add-maxes", {
        method: 'Post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, body: JSON.stringify(data)
    }
    )
}



const GetAllUsers = () => {
    return fetch(
        `http://localhost:9800/admin-user/get-users`
    )
}

const DeleteUserById = (id) => {
    return fetch(`http://localhost:9800/admin-user/delete-user/${id}`, {

    });

}
const RegisterUser = (data) => {
    return fetch("http://localhost:9800/api/v1/auth/register", {
        method: 'Post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, body: JSON.stringify(data)
    }
    )
}
const LoginToUserPage = (login) => {
    return fetch("http://localhost:9800/api/v1/auth/authenticate", {
        method: 'Post',

        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, body: JSON.stringify(login)
    }
    )
}


export { addUserMaxes, getUserData, updateUsersData, getUserMaxes, GetAllUsers, DeleteUserById, RegisterUser, LoginToUserPage }