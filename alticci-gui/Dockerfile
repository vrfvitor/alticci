FROM node:16-alpine

MAINTAINER Vitor Ferreira <vrfvitor@hotmail.com>

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

COPY package.json ./
COPY package-lock.json ./

RUN npm install

COPY . ./

EXPOSE 4200
CMD ["npm", "start"]
