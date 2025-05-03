terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.27"
    }
  }
}

module "my-s3-module" {
  source = "./modules/s3-module"
  bucket_name = "2022010198756-mybucketname"
}

# module "vpc" {
#   source = "terraform-aws-modules/vpc/aws"

#   name = "my-vpc"
#   cidr = "10.0.0.0/16"

#   azs             = ["us-west-2"]
#   private_subnets = ["10.0.1.0/24", "10.0.2.0/24", "10.0.3.0/24"]
#   public_subnets  = ["10.0.101.0/24", "10.0.102.0/24", "10.0.103.0/24"]

#   enable_nat_gateway = true
#   enable_vpn_gateway = true
# }

provider "aws" {
  profile = "default"
  region  = "us-west-2"
}

output "public_ip" {
  value = aws_instance.app_server.public_ip
}

resource "aws_instance" "app_server" {
  ami                    = "ami-830c94e3"
  instance_type          = "t2.micro"
  vpc_security_group_ids = [aws_security_group.allow_port_8080.id]
  user_data              = <<-EOF
            #!/bin/bash
            echo "<h1>My server is up!</h1>" > index.html
            nohup busybox httpd -f -p ${var.port_number}
            EOF
  tags = {
    Name = "ec2-${var.tag_name}"
  }
}

resource "aws_security_group" "allow_port_8080" {
  name        = "${terraform.workspace}-allow_port_8080"
  description = "Allow 8080 inbound traffic"

  ingress {
    from_port   = var.port_number
    to_port     = var.port_number
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "sg-${var.tag_name}"
  }
}

# resource "aws_s3_bucket" "b" {
#   count = 3
#   bucket = "2022010145-app_image_bucket-${count.index}"
# }

data "aws_vpc" "default" {
  default = true
}

data "aws_subnet_ids" "subnet_ids" {
  vpc_id = data.aws_vpc.default.id
}

output "aws_default_vpc_info" {
  value = data.aws_vpc.default
  description = "info about default VPC"
}

output "aws_default_vpc_subnet_ids" {
  value = data.aws_subnet_ids.subnet_ids
  description = "Subnet IDs"
}