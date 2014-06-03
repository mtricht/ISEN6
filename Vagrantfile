Vagrant.configure("2") do |config|
  config.vm.box = "chef/centos-6.5"
  config.vm.network :forwarded_port, guest: 80, host: 80
  config.vm.network :forwarded_port, guest: 3306, host: 3306
  config.vm.network :forwarded_port, guest: 5000, host: 5000
  config.vm.provision "shell", path: "./vagrant-setup.sh"
  config.vm.synced_folder "./web", "/var/www/html/web"
  config.vm.synced_folder "./server", "/var/www/html/server"
end