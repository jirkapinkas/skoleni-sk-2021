#!/bin/sh
while true
do
	echo "Writing log to myapp.log"
  echo '{"app":"file-myapp"}' >> /app/myapp.log
	sleep 5
done