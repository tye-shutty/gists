aws ssm start-session --target i-008d9718980b37ff2
#to enter the node
sudo -s
#to enter commands on the node
systemctl list-units
#lists processes (units)
journalctl -u <unit>
#retrieves logs on that unit
docker ps
#lists docker containers

chmod 400 ~/.ssh/first-pair.pem
#protects from public viewing
ssh -i /Users/tshutty/.ssh/first-pair.pem ec2-user@ec2-3-93-4-175.compute-1.amazonaws.com
#connects to the instance

services > rds > databases > writer > actions >failover

#version found with tags.3.value in jenkins roll cluster
#service name found with service= in jenkins generate properties

#sending files
scp -i "aws-ubuntu.pem" ~/the-eagle.txt ubuntu@ec2-18-222-250-155.us-east-2.compute.amazonaws.com:~/
