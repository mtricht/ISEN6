#! /bin/bash

# Requirements
sudo rpm -Uvh http://mirror.webtatic.com/yum/el6/latest.rpm
sudo yum -y install vim httpd mysql mysql-server php55w php55w-opcache php55w-mysql php55w-devel gcc libtool git wget pcre-devel.x86_64 python-devel mysql-devel.x86_64

# pip and flask
sudo wget https://bootstrap.pypa.io/get-pip.py
sudo python get-pip.py
sudo pip install flask
sudo pip install flask-mysql

# Phalconphp
sudo git clone --depth=1 git://github.com/phalcon/cphalcon.git
cd cphalcon/build
sudo ./install
sudo echo 'extension=phalcon.so' > /etc/php.d/phalcon.ini
sudo git clone git://github.com/phalcon/phalcon-devtools.git
cd phalcon-devtools/
sudo ./phalcon.sh
sudo ln -s ~/phalcon-devtools/phalcon.php /usr/bin/phalcon
sudo chmod ugo+x /usr/bin/phalcon

# Start stuff
sudo chkconfig httpd on
sudo chkconfig mysqld on
sudo service mysqld start
sudo service httpd start

# bitcoind
sudo rpm -ivh http://tvdw.eu/bitcoin-0.8.1-1.el6.`uname -m`.rpm

# Sometimes httpd wont start.
# AllowOverride is enabled in /etc/httpd/conf/httpd.conf