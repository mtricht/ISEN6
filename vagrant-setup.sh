#! /bin/bash

# Requirements
sudo rpm -Uvh http://mirror.webtatic.com/yum/el6/latest.rpm
sudo yum -y install vim httpd mysql mysql-server php55w php55w-opcache php55w-mysql php55w-devel gcc libtool git wget pcre-devel.x86_64 python-devel mysql-devel.x86_64 mod_wsgi.x86_64

# pip
if [ ! -f "get-pip.py" ]; then
	sudo wget https://bootstrap.pypa.io/get-pip.py
	sudo python get-pip.py
fi

# Flask
sudo pip install flask flask-mysql python-bitcoinrpc simplejson

# Python cryptography
if [ ! -d "pycrypto-2.6.1" ]; then
	sudo wget https://ftp.dlitz.net/pub/dlitz/crypto/pycrypto/pycrypto-2.6.1.tar.gz
	sudo tar -xzvf pycrypto-2.6.1.tar.gz
	sudo python pycrypto-2.6.1/setup.py install
fi

# Phalconphp
if [ ! -d "cphalcon" ]; then
	sudo git clone --depth=1 git://github.com/phalcon/cphalcon.git
	cd cphalcon/build
	sudo ./install
	sudo echo 'extension=phalcon.so' > /etc/php.d/phalcon.ini
	sudo git clone git://github.com/phalcon/phalcon-devtools.git
	cd phalcon-devtools/
	sudo ./phalcon.sh
	sudo ln -s ~/phalcon-devtools/phalcon.php /usr/bin/phalcon
	sudo chmod ugo+x /usr/bin/phalco
fi

# Start stuff
sudo chkconfig httpd on
sudo chkconfig mysqld on
sudo service mysqld start
sudo service httpd start

# bitcoind
sudo rpm -ivh http://tvdw.eu/bitcoin-0.8.1-1.el6.`uname -m`.rpm

sed -i 's/AllowOverride None/AllowOverride All/g' /etc/httpd/conf/httpd.conf

if [sed -n '$=' /etc/httpd/conf/httpd.conf < 1010]; then
	echo WSGIScriptAlias /server /var/www/html/server/server.wsgi >> /etc/httpd/conf/httpd.conf
fi