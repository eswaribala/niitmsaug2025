from django.db import models

# Create your models here.
class Customer(models.Model):
    first_name = models.CharField(max_length=100)
    last_name = models.CharField(max_length=100)
    email = models.EmailField(unique=True)
    phone = models.CharField(max_length=15, blank=True)
    account_no = models.IntegerField(primary_key=True)
    password = models.CharField(max_length=10)
    created_at = models.DateTimeField(auto_now_add=True)
    def __str__(self):
        return f"{self.first_name} {self.last_name}, {self.email}, {self.phone}, {self.account_no}, {self.created_at}"


class Address(models.Model):
    door_no=models.CharField(max_length=5)
    street = models.CharField(max_length=100)
    city = models.CharField(max_length=100)
    state = models.CharField(max_length=100)
    zip_code = models.CharField(max_length=10)
    customer = models.ForeignKey(Customer, on_delete=models.CASCADE, related_name='addresses')
    def __str__(self):
        return f"{self.door_no}, {self.street}, {self.city}, {self.state}, {self.zip_code}, {self.customer}"