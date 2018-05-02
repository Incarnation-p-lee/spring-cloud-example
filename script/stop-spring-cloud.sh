#!/bin/bash

raw=`ps | grep java | cut -d ' ' -f1-6`
process=(${raw})

for p in ${process[@]}
do
    echo kill process $p
    kill -9 $p
done

