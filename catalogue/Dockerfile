FROM node:10

EXPOSE 8080

WORKDIR /opt/server

ADD package.json /opt/server/

RUN npm install

ADD server.js /opt/server/

CMD ["node", "server.js"]

