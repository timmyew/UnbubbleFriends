FROM ubuntu:latest
LABEL authors="Timmy Ewrard"

RUN apt-get update

RUN apt-get install -y mariadb-server

EXPOSE 3306

LABEL version="1.0"
LABEL description="UnbubbleFriends development environment."

HEALTHCHECK --start-period=1m CMD mariadb -e 'SELECT @@datadir;' || exit 1

CMD ["mariadbd"]
