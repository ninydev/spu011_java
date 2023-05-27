const axios = require('axios')
// Создание сервера
const express = require('express');
const app = express();
const serverName = process.env.NAME || 'Node Api';
const PORT = process.env.PORT || 3000;

const OPENAI_API_KEY = process.env.OPENAI_API_KEY

async function fetchChatGPT(question) {
    const options = {
        method: 'POST',
        url: 'https://api.openai.com/v1/completions',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${OPENAI_API_KEY}`, // Здесь нужно указать свой API ключ
        },
        data: {
            "model": "text-davinci-002",
            "prompt": question,
            "max_tokens": 1204,
            "temperature": 1,
            "top_p": 1,
            "n": 1,
            "stream": false,
            // "logprobs": null,
            // "stop": "\n"
        },
    };

    const response = await axios(options);
    const data = response.data;

    const text = data.choices[0].text.trim();
    return text;
}


app.get('/node/api/chat', function (request, response) {

    let question = "Посетитель моего сайта спрашивает: " +  request.query.q + "\n ответ ожидаем на русском языке "
    console.log (question)

    fetchChatGPT(question)
        .then(answer => {
            response.status(200).json({
                "answer" : answer
            })
        })
        .catch(err => {
            response.status(419).json({
                "error" : err
            })
        })



})

// Запустил сервер
app.listen(PORT, () => console.log("Server running at port " + PORT));
