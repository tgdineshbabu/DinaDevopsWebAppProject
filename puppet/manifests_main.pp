node 'puppetagent' {
	file {"/dinatemp.txt":
	ensure => "present",
	content => "learning puppet\nEntering line ",
	}
	package {'docker':
        ensure => 'present',
        }
        service {'docker':
        ensure => 'true',
        }
} 
