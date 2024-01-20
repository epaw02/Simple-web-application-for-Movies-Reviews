FROM node:latest as build

WORKDIR /app
COPY . .

RUN npm install
RUN npm run build

FROM nginx:1.23.3


ENV VERSION="0.0.1-SNAPSHOT"
ENV API_URL http://gateway:8080/api

EXPOSE 80

ADD dist/angular-app /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
