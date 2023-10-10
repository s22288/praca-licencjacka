function calculateCaloriesDemandBaseOnUser() {
    return fetch("http://localhost:9800/normal-user/account-data")
}



function updateUsersData(data) {
    return fetch("http://localhost:9800/normal-user/update-data", {
        method: 'Post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }, body: JSON.stringify(data)
    }
    )
}


export { calculateCaloriesDemandBaseOnUser, updateUsersData }