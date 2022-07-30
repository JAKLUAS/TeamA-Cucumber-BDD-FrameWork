#!/bin/sh
 mvn verify -Dbrowser=edge
 mvn verify -Dbrowser=chrome
 mvn verify -Dbrowser=firefox
