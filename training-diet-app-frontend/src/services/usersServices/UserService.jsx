
 function  getUserData() {
    return  fetch("http://localhost:9800/normal-user/account-data")
}


function  getUserMaxes() {
    return  fetch("http://localhost:9800/normal-user/user-maxes")
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

function CreateAccount(){

}



export { addUserMaxes,getUserData, updateUsersData,getUserMaxes,CreateAccount }