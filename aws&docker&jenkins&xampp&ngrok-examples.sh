#to enter the node
aws ssm start-session --target i-008d9718980b37ff2

#to enter commands on the node
sudo -s
#lists processes (units)
systemctl list-units
#retrieves logs on that unit
journalctl -u <unit>
#lists docker containers
docker ps

#protects from public viewing
chmod 400 ~/.ssh/first-pair.pem
#allows file to execute (for installing xampp)
chmod 755 <path to file>

ssh -i /Users/tshutty/.ssh/first-pair.pem ec2-user@ec2-3-93-4-175.compute-1.amazonaws.com
ssh -i "aws-ubuntu.pem" ubuntu@ec2-18-222-250-155.us-east-2.compute.amazonaws.com
ssh -i "~/aws.pem" ec2-user@ec2-34-222-6-68.us-west-2.compute.amazonaws.com
#connects to the instance

services > rds > databases > writer > actions >failover

#version found with tags.3.value in jenkins roll cluster
#service name found with service= in jenkins generate properties

#sending files
scp -i "~/aws-ubuntu.pem" -r ~/codebase/swe4103-team-1/Project ubuntu@ec2-18-222-250-155.us-east-2.compute.amazonaws.com:~/
	# add r to send folders
scp -r tshutty@fcslinux.cs.unb.ca:~/.mozilla/firefox/9hei58zo.default-1528038513469-1567872944774 ~
    #works both ways
    
sudo find / -iname xampp
# /opt/lampp/share/xampp
# /opt/lampp/xampp
# /opt/lampp/etc/xampp

#start webserver
sudo /opt/lampp/lampp start
#control panel
sudo /opt/lampp/manager-linux-x64.run
#list of commands
sudo /opt/lampp/lampp
#XAMPP by default uses /opt/lampp/htdocs as the root web directory.
sudo ln -s ~/public_html /opt/lampp/htdocs/mystuff
# The MySQL administrator (root) has no password.
# The MySQL daemon is accessible via network.
# ProFTPD uses the password "lampp" for user "nobody".
# PhpMyAdmin is accessible via network.
# Examples are accessible via network.
# MySQL and Apache running under the same user (nobody).

#release the pups (lampp default port)
~/ngrok http 80

##ngrok opens HTTP tunnel to local webserver

#location of website
/opt/lampp/htdocs

## docker for aws linux 2:
#https://docs.aws.amazon.com/AmazonECS/latest/developerguide/docker-basics.html#install_docker

## docker for ubuntu:
#https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-18-04

## set password for aws user on instance:
#https://aws.amazon.com/premiumsupport/knowledge-center/ec2-password-login/
sudo passwd ec2-user

## get into docker image to see dockerfile
sudo docker run -t -i --entrypoint bash tshutty/tye-ubuntu-repo:tye-init
## run docker in background
docker run -d

## interactive shell access to container
docker run -it clojure


#installs stuff
sudo wget https://www.apachefriends.org/xampp-files/7.3.10/xampp-linux-x64-7.3.10-0-installer.run

#links a existing folder source.file to link softlink.file
ln -s source.file softlink.file

#in case you forget what localhost looks like
http://localhost:8080/

#npm stuff
npm install
npm run build
npm install http-server -g
http-server dist/

##aws details
#allow this (lab) ip
131.202.241.225/32
#Is it possible to test a webserver on localhost that connects to a locally running database with ngrok?
#https://www.reddit.com/r/webdev/submit?selftext=true

#db
#/phpMyAdmin/
#Parameter validation failed: parameter value for parameter name KeyName does not exist
sudo service mysqld start


##https://aws.amazon.com/ec2/faqs/
#Stop and hibernate are available for Amazon EBS backed instances only. Hibernating instances are charged at standard EBS rates for storage. As with a stopped instance, you do not incur instance usage fees while an instance is hibernating. Hibernation needs to be enabled when you launch the instance. Hibernated instances are in ‘Stopped’ state.

##aws lampp
#https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/install-LAMP.html
#app goes here: /var/www/html
chkconfig --list httpd
#running = 0:off   1:off   2:on    3:on    4:on    5:on    6:off
sudo service httpd restart
